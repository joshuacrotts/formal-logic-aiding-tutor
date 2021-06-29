package com.flat.input;

import com.flat.FLAT;
import com.flat.FLATBaseListener;
import com.flat.FLATParser;
import com.flat.models.treenode.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.Stack;

/**
 * FLATParserListener is the connector that defines the syntax and,
 * more importantly, the semantic analysis - how errors are defined
 * and reported. Each method inherited from FLATBaseListener comes
 * from the grammar FLAT.g4 file and correspond to parser rules.
 *
 * @author Joshua Crotts
 * @date 2/20/2021
 */
public class FLATParserListener extends FLATBaseListener {

    /**
     *
     */
    public static final int MAXIMUM_NEGATED_NODES = 4;

    /**
     * Map to keep track of nodes across the different listener
     * methods.
     */
    private final ParseTreeProperty<WffTree> PARSE_TREE;

    /**
     * FLATParser object brought from the ParserTest.
     */
    private final FLATParser FLAT_PARSER;

    /**
     *
     */
    private final FLATPredicateTable predicateTable;

    /**
     * Stack to keep track of all in-progress subwffs.
     */
    private final Stack<WffTree> treeRoots;

    /**
     * ArrayList to return to the user of all WffTrees that were inputted.
     */
    private final ArrayList<WffTree> currentTrees;

    /**
     * Current root of the wff tree being constructed.
     */
    private WffTree wffTree;

    /**
     * Keeps track of how many negation nodes we currently have stacked. Any other node resets this to 0.
     * 4 is the max.
     */
    private int negationCount = 0;

    public FLATParserListener(FLATParser _flatParser) {
        super();

        this.FLAT_PARSER = _flatParser;
        this.PARSE_TREE = new ParseTreeProperty<>();
        this.predicateTable = new FLATPredicateTable();
        this.treeRoots = new Stack<>();
        this.currentTrees = new ArrayList<>();
    }

    @Override
    public void enterPropositionalWff(FLATParser.PropositionalWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
        if (this.wffTree != null && this.wffTree.isPredicateWff()) {
            FLATErrorListener.syntaxError(ctx, "Wff cannot be both propositional and predicate.");
            return;
        }

        this.wffTree = new WffTree();
        this.wffTree.setFlags(NodeFlag.PROPOSITIONAL);
    }

    @Override
    public void exitPropositionalWff(FLATParser.PropositionalWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.currentTrees.add(this.wffTree.copy());
    }

    @Override
    public void enterAtom(FLATParser.AtomContext ctx) {
        if (FLATErrorListener.sawError()) return;
        WffTree atomNode = new AtomNode(ctx.ATOM().getText());
        this.PARSE_TREE.put(ctx, atomNode);
    }

    @Override
    public void enterPropWff(FLATParser.PropWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
    }

    @Override
    public void exitPropWff(FLATParser.PropWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
        if (ctx.atom() != null) {
            this.wffTree.addChild(this.PARSE_TREE.get(ctx.atom()));
        }
    }

    @Override
    public void enterPropNegRule(FLATParser.PropNegRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.negationCount++;
        if (this.negationCount > FLATParserListener.MAXIMUM_NEGATED_NODES) {
            FLATErrorListener.syntaxError(ctx, "Error: cannot have more than four stacked negated nodes");
            return;
        }

        String symbol = ctx.NEG().getText();
        NegNode negNode = new NegNode(symbol);
        this.treeRoots.push(this.wffTree);
        this.wffTree = negNode;
    }

    @Override
    public void exitPropNegRule(FLATParser.PropNegRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.negationCount--;
        this.popTreeRoot();
    }

    @Override
    public void enterPropAndRule(FLATParser.PropAndRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        AndNode andNode = new AndNode(ctx.AND().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = andNode;
    }

    @Override
    public void exitPropAndRule(FLATParser.PropAndRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPropOrRule(FLATParser.PropOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        OrNode orNode = new OrNode(ctx.OR().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = orNode;
    }

    @Override
    public void exitPropOrRule(FLATParser.PropOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPropImpRule(FLATParser.PropImpRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        ImpNode impNode = new ImpNode(ctx.IMP().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = impNode;
    }

    @Override
    public void exitPropImpRule(FLATParser.PropImpRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPropBicondRule(FLATParser.PropBicondRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        BicondNode bicondNode = new BicondNode(ctx.BICOND().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = bicondNode;
    }

    @Override
    public void exitPropBicondRule(FLATParser.PropBicondRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPropExclusiveOrRule(FLATParser.PropExclusiveOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        ExclusiveOrNode xorNode = new ExclusiveOrNode(ctx.XOR().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = xorNode;
    }

    @Override
    public void exitPropExclusiveOrRule(FLATParser.PropExclusiveOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

//========================== PREDICATE LOGIC LISTENERS =============================//

    @Override
    public void enterPredicateWff(FLATParser.PredicateWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
        if (this.wffTree != null && this.wffTree.isPropositionalWff()) {
            FLATErrorListener.syntaxError(ctx, "Wff cannot be both propositional and predicate.");
            return;
        }

        this.wffTree = new WffTree();
        this.wffTree.setFlags(NodeFlag.PREDICATE);
    }

    @Override
    public void exitPredicateWff(FLATParser.PredicateWffContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.currentTrees.add(this.wffTree.copy());
    }

    @Override
    public void exitPredicate(FLATParser.PredicateContext ctx) {
        if (FLATErrorListener.sawError()) return;
        AtomNode atomNode = (AtomNode) this.PARSE_TREE.get(ctx.atom());

        // Loop through the children and add them to the list.
        // Each parameter is either a constant or variable.
        ArrayList<WffTree> parameters = new ArrayList<>();
        for (int i = 1; i < ctx.children.size(); i++) {
            parameters.add(this.PARSE_TREE.get(ctx.getChild(i)));
        }

        String atomLetter = atomNode.toString().replaceAll("ATOM: ", "");
        PredicateNode predicate = new PredicateNode(atomLetter, parameters);

        // Check to see if a definition exists and differs from this one. Throws a syntax error if so.
        if (predicateTable.isDifferent(predicate)) {
            FLATErrorListener.syntaxError(ctx, "Predicate " + atomLetter + " has arity " + parameters.size()
                    + " but a previous version of " + atomLetter
                    + " has arity " + this.predicateTable.getArity(predicate) + ".");
        }

        this.wffTree.addChild(predicate);
        this.predicateTable.addPredicate(predicate);
    }

    @Override
    public void enterConstant(FLATParser.ConstantContext ctx) {
        if (FLATErrorListener.sawError()) return;
        WffTree constantNode = new ConstantNode(ctx.CONSTANT().getText());
        this.PARSE_TREE.put(ctx, constantNode);
    }

    @Override
    public void enterVariable(FLATParser.VariableContext ctx) {
        if (FLATErrorListener.sawError()) return;
        WffTree variableNode = new VariableNode(ctx.VARIABLE().getText());
        this.PARSE_TREE.put(ctx, variableNode);
    }

    @Override
    public void exitPredQuantifier(FLATParser.PredQuantifierContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void exitUniversal(FLATParser.UniversalContext ctx) {
        if (FLATErrorListener.sawError()) return;
        VariableNode variableNode = null;

        if (ctx.variable() != null) {
            variableNode = (VariableNode) this.PARSE_TREE.get(ctx.variable());
        } else {
            FLATErrorListener.syntaxError(ctx, "missing variable declaration for universal quantifier.");
            return;
        }

        String symbol = "("
                + (ctx.UNIVERSAL() != null ? ctx.UNIVERSAL().getText() : "")
                + (ctx.variable().getText())
                + ")";

        UniversalQuantifierNode uqn = new UniversalQuantifierNode(symbol, variableNode.getSymbol());
        this.treeRoots.push(this.wffTree);
        this.wffTree = uqn;
    }

    @Override
    public void exitExistential(FLATParser.ExistentialContext ctx) {
        if (FLATErrorListener.sawError()) return;
        VariableNode variableNode = null;

        if (ctx.variable() != null) {
            variableNode = (VariableNode) this.PARSE_TREE.get(ctx.variable());
        } else {
            FLATErrorListener.syntaxError(ctx, "missing variable declaration for existential quantifier.");
            return;
        }

        String symbol = "("
                + ctx.EXISTENTIAL().getText()
                + ctx.variable().getText()
                + ")";

        ExistentialQuantifierNode uqn = new ExistentialQuantifierNode(symbol, variableNode.getSymbol());
        this.treeRoots.push(this.wffTree);
        this.wffTree = uqn;
    }

    @Override
    public void enterPredNegRule(FLATParser.PredNegRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.negationCount++;

        NegNode negNode = new NegNode(ctx.NEG().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = negNode;
    }

    @Override
    public void exitPredNegRule(FLATParser.PredNegRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        if (this.negationCount > FLATParserListener.MAXIMUM_NEGATED_NODES) {
            FLATErrorListener.syntaxError(ctx, "Error: cannot have more than four stacked negated nodes");
            return;
        }

        this.negationCount--;
        this.popTreeRoot();
    }

    @Override
    public void enterPredAndRule(FLATParser.PredAndRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        AndNode andNode = new AndNode(ctx.AND().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = andNode;
    }

    @Override
    public void exitPredAndRule(FLATParser.PredAndRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPredOrRule(FLATParser.PredOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        OrNode orNode = new OrNode(ctx.OR().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = orNode;
    }

    @Override
    public void exitPredOrRule(FLATParser.PredOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPredImpRule(FLATParser.PredImpRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        ImpNode impNode = new ImpNode(ctx.IMP().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = impNode;
    }

    @Override
    public void exitPredImpRule(FLATParser.PredImpRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPredBicondRule(FLATParser.PredBicondRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        BicondNode bicondNode = new BicondNode(ctx.BICOND().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = bicondNode;
    }

    @Override
    public void exitPredBicondRule(FLATParser.PredBicondRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void enterPredExclusiveOrRule(FLATParser.PredExclusiveOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        ExclusiveOrNode xorNode = new ExclusiveOrNode(ctx.XOR().getText());
        this.treeRoots.push(this.wffTree);
        this.wffTree = xorNode;
    }

    @Override
    public void exitPredExclusiveOrRule(FLATParser.PredExclusiveOrRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        this.popTreeRoot();
    }

    @Override
    public void exitPredIdentityRule(FLATParser.PredIdentityRuleContext ctx) {
        if (FLATErrorListener.sawError()) return;
        IdentityNode identityNode = new IdentityNode();
        identityNode.addChild(this.PARSE_TREE.get(ctx.getChild(0)));
        identityNode.addChild(this.PARSE_TREE.get(ctx.getChild(2)));

        this.wffTree.addChild(identityNode);
    }

    /**
     * Returns the list of WffTrees that were constructed during parsing. Multiple are
     * possible if a comma is used as the delimiter.
     *
     * @return ArrayList of WffTrees. If there is only one, then only one WffTree should
     * be evaluated. Otherwise, use an algorithm for 2+.
     */
    public ArrayList<WffTree> getSyntaxTrees() {
        return FLATErrorListener.sawError() ? null : this.currentTrees;
    }

    /**
     * Pops the root of the tree - each time a node with a potentially
     * left-recursive child is called (namely wff), we need to start adding
     * onto that specific WffTree. So, we save the old root into a stack,
     * and continue to add onto the new running "root". When we finish, we pop the
     * stack, add the running root as a child of the old root, and finally
     * reassign the links.
     */
    private void popTreeRoot() {
        WffTree oldRoot = this.treeRoots.pop(); // Remove the old root from the stack.
        oldRoot.addChild(this.wffTree); // Add the current running-node as a child of the old root.
        this.wffTree = oldRoot; // Reassign the root to be the old one.
    }
}