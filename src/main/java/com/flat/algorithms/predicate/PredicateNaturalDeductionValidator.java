package com.flat.algorithms.predicate;

import com.flat.algorithms.BaseNaturalDeductionValidator;
import com.flat.algorithms.BaseTruthTreeGenerator;
import com.flat.algorithms.models.NDFlag;
import com.flat.algorithms.models.NDStep;
import com.flat.algorithms.models.NDWffTree;
import com.flat.algorithms.models.ProofType;
import com.flat.models.treenode.*;
import com.flat.tools.FLATUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public final class PredicateNaturalDeductionValidator extends BaseNaturalDeductionValidator {

    /**
     * Timeout iterator - if the number of iterations goes beyond this, we return
     * a null proof.
     */
    private static int timeout = 1000;

    /**
     * Set to keep track of all constants that are in the premises.
     */
    private final HashSet<Character> constants;

    /**
     * Set to keep track of all constants that are only in the conclusion.
     */
    private final HashSet<Character> conclusionConstants;

    /**
     *
     */
    private int cycles;

    public PredicateNaturalDeductionValidator(ArrayList<WffTree> _wffTreeList, ProofType _proofType) {
        super(_wffTreeList, _proofType);
        // Get all constants and conclusion constants...
        this.constants = new HashSet<>();
        this.conclusionConstants = new HashSet<>();
        for (int i = 0; i < _wffTreeList.size() - 1; i++)
            this.addAllConstantsToSet(_wffTreeList.get(i), this.constants);
        this.addAllConstantsToSet(_wffTreeList.get(_wffTreeList.size() - 1), this.conclusionConstants);
    }

    /**
     * Computes a natural deduction proof for a predicate logic formula. We use a couple of heuristics to ensure
     * the runtime/search space isn't COMPLETELY insane (those being that we only apply certain rules if others fail
     * to produce meaningful results, etc.).
     * <p>
     * Note that, for FOPL, we do NOT check to see if the argument is invalid with a truth tree first. This is because
     * it is sometimes easier to prove a formula in ND than it is to algorithmically generate a closed truth tree.
     *
     * @return list of NDWffTree "args". These serve as the premises, with the last element in the list being
     * the conclusion.
     */
    @Override
    public ArrayList<NDWffTree> getNaturalDeductionProof() {
        while (true) {
            // Check for a contradiction, the conclusion, and a timeout.
            // If we are in an indirect proof, we can only break via contr and timeouts.
            boolean timeout = this.cycles++ > PredicateNaturalDeductionValidator.timeout;
            if (this.proofType == ProofType.INDIRECT) {
                if (this.findContradictions() || timeout) break;
            } else {
                if (this.findConclusion() || this.findContradictions() || timeout) break;
            }

            // First try to satisfy the premises.
            for (int i = 0; i < this.premisesList.size(); i++) {
                NDWffTree premise = this.premisesList.get(i);
                this.satisfy(premise.getWffTree(), premise);
            }

            // Now try to satisfy the conclusion and its equivalences.
            this.satisfy(this.conclusionWff.getWffTree(), this.conclusionWff);
            for (NDWffTree conclusionEquivalence : this.findConclusionEquivalentsFOPL()) {
                this.satisfy(conclusionEquivalence.getWffTree(), conclusionEquivalence);
            }
        }

        // The timeout is there to prevent completely insane proofs from never ending.
        if (this.cycles > PredicateNaturalDeductionValidator.timeout) {
            return null;
        }

        // Go through and replace the sorted assumptions with the original indices.
        for (int r = 0; r < this.originalPremisesList.size(); r++) {
            this.premisesList.set(r, this.originalPremisesList.get(r));
        }

        // Backtrack from the conclusion to mark all those nodes that were used in the proof.
        this.activateLinks(this.conclusionWff);

        // Add the premises that were actually used in the argument.
        return this.assignParentIndices();
    }

    /**
     * Creates a list of equivalent forms of the conclusion to see if we have
     * satisfied any of them. If so, we convert that premise into the equivalent
     * form and say that we satisfied the conclusion and proof. There are four
     * equivalences:
     * <p>
     * Double Negation ~~C
     * Transposition C = (A -> B) <> (~B -> ~A)
     * DeMorgan's Laws
     * Material Implication C = (A -> B) <> (~A | B)
     * <p>
     * Yes, this is ugly, but hopefully it works.
     *
     * @return ArrayList of equivalent forms of the conclusion if they exist.
     */
    protected ArrayList<NDWffTree> findConclusionEquivalentsFOPL() {
        ArrayList<NDWffTree> conclusionEquivalentList = new ArrayList<>();
        WffTree conclusionNode = this.conclusionWff.getWffTree();
        // First do a double negation equivalence.
        if (conclusionNode.isDoubleNegation()) {
            conclusionEquivalentList.add(new NDWffTree(conclusionNode.getChild(0).getChild(0), NDFlag.TP | NDFlag.DNE | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.DNE, this.conclusionWff));
        }
        // First do a transposition equivalence.
        if (conclusionNode.isImp()) {
            ImpNode transpositionNode = new ImpNode();
            transpositionNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(1)));
            transpositionNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0)));
            this.conclusionWff.setFlags(NDFlag.TP);
            conclusionEquivalentList.add(new NDWffTree(transpositionNode, NDFlag.TP | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.TP, this.conclusionWff));
        }

        // Now do a demorgan's equivalence.
        if (conclusionNode.isNegation() || conclusionNode.isBinaryOp()) {
            WffTree deMorganNode = null;
            // Negate a biconditional to get ~(X <-> Y) => ~((X->Y) & (Y->X)).
            if (conclusionNode.isNegation() && conclusionNode.getChild(0).isBicond()) {
                ImpNode lhs = new ImpNode(conclusionNode.getChild(0).getChild(0), conclusionNode.getChild(0).getChild(1));
                ImpNode rhs = new ImpNode(conclusionNode.getChild(0).getChild(1), conclusionNode.getChild(0).getChild(0));
                AndNode and = new AndNode(lhs, rhs);
                NegNode neg = new NegNode(and);
                deMorganNode = neg;
            }
            // "Unnegate" a conjunction with two implications to get the negated biconditional.
            else if (conclusionNode.isNegation() && conclusionNode.getChild(0).isAnd()
                    && conclusionNode.getChild(0).getChild(0).isImp() && conclusionNode.getChild(0).getChild(1).isImp()
                    && conclusionNode.getChild(0).getChild(0).getChild(0).stringEquals(conclusionNode.getChild(0).getChild(1).getChild(1))
                    && conclusionNode.getChild(0).getChild(0).getChild(1).stringEquals(conclusionNode.getChild(0).getChild(1).getChild(0))) {
                BicondNode bicondNode = new BicondNode(conclusionNode.getChild(0).getChild(0).getChild(0),
                        conclusionNode.getChild(0).getChild(0).getChild(1));
                NegNode negNode = new NegNode(bicondNode);
                deMorganNode = negNode;
            }
            // Four types: one is ~(X B Y) => (~X ~B ~Y)
            else if (conclusionNode.isNegation() && (conclusionNode.getChild(0).isOr() || conclusionNode.getChild(0).isAnd() || conclusionNode.getChild(0).isImp())) {
                deMorganNode = BaseTruthTreeGenerator.getNegatedBinaryNode(conclusionNode.getChild(0)); // B
                deMorganNode.addChild(conclusionNode.getChild(0).isImp() ? conclusionNode.getChild(0).getChild(0)
                        : BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0).getChild(0))); // LHS X
                deMorganNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0).getChild(1))); // RHS Y
            }
            // Other is (X B Y) => ~(~X ~B ~Y)
            else if ((conclusionNode.isOr() || conclusionNode.isAnd() || conclusionNode.isImp())) {
                WffTree negBinaryNode = BaseTruthTreeGenerator.getNegatedBinaryNode(conclusionNode); // B
                negBinaryNode.addChild(conclusionNode.isImp() ? conclusionNode.getChild(0) : BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0))); // LHS X
                negBinaryNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(1))); // RHS Y
                deMorganNode = new NegNode(negBinaryNode);
            }
            // Other turns ~(x)W to (Ex)~W
            else if (conclusionNode.isNegation() && conclusionNode.getChild(0).isUniversal()) {
                String v = ((UniversalQuantifierNode) conclusionNode.getChild(0)).getVariableSymbol();
                ExistentialQuantifierNode existentialQuantifierNode = new ExistentialQuantifierNode(v);
                NegNode neg = new NegNode();
                neg.addChild(conclusionNode.getChild(0).getChild(0));
                existentialQuantifierNode.addChild(neg);
                deMorganNode = existentialQuantifierNode;
            }
            // Last turns ~(Ex)W to (x)~W
            else if (conclusionNode.isNegation() && conclusionNode.getChild(0).isExistential()) {
                String v = ((ExistentialQuantifierNode) conclusionNode.getChild(0)).getVariableSymbol();
                UniversalQuantifierNode universalQuantifierNode = new UniversalQuantifierNode(v);
                NegNode neg = new NegNode();
                neg.addChild(conclusionNode.getChild(0).getChild(0));
                universalQuantifierNode.addChild(neg);
                deMorganNode = universalQuantifierNode;
            }
            // If we found a node, then it'll be applied/inserted here.
            if (deMorganNode != null) {
                this.conclusionWff.setFlags(NDFlag.MI);
                NDWffTree ndWffTree = new NDWffTree(deMorganNode, NDFlag.TP | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.DEM, this.conclusionWff);
                conclusionEquivalentList.add(ndWffTree);
            }
        }

        // Finally, do a material implication equivalence.
        if (conclusionNode.isImp() || conclusionNode.isOr()) {
            WffTree newWff = null;
            // Convert (P -> Q) to (~P V Q).3
            if (conclusionNode.isImp()) {
                NegNode negLhs = new NegNode(conclusionNode.getChild(0));
                OrNode orNode = new OrNode(negLhs, conclusionNode.getChild(1));
                newWff = orNode;
            }
            // Convert (~P V Q) to (P -> Q)
            else if (conclusionNode.isOr()) {
                WffTree lhs = conclusionNode.getChild(0);
                WffTree rhs = conclusionNode.getChild(1);
                if (lhs.isNegation()) {
                    ImpNode impNode = new ImpNode(lhs.getChild(0), rhs); // Un-negate the lhs.
                    newWff = impNode;
                }
            }
            // If we performed a MI then add it.
            if (newWff != null) {
                this.conclusionWff.setFlags(NDFlag.MI);
                NDWffTree ndWffTree = new NDWffTree(newWff, NDFlag.TP | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.MI, this.conclusionWff);
                conclusionEquivalentList.add(ndWffTree);
            }
        }
        return conclusionEquivalentList;
    }

    /**
     * Attempts to satisfy a WffTree and its parent node.
     *
     * @param _tree - WffTree that is passed recursively.
     * @param _parent - NDWffTree that parents the original WffTree in the recursive calls.
     * @return NDWffTree that was satisfied, null if no satisfaction was discovered.
     */
    private NDWffTree satisfy(WffTree _tree, NDWffTree _parent) {
        NDWffTree satisfiedNDWffTree = null;
        if (_tree.isPredicate() || _tree.isNegPredicate()) {
            satisfiedNDWffTree = this.satisfyPredicate(_tree, _parent);
        } else if (_tree.isImp()) {
            satisfiedNDWffTree = this.satisfyImplication(_tree, _parent);
        } else if (_tree.isAnd()) {
            satisfiedNDWffTree = this.satisfyConjunction(_tree, _parent);
        } else if (_tree.isOr()) {
            satisfiedNDWffTree = this.satisfyDisjunction(_tree, _parent);
        } else if (_tree.isBicond()) {
            satisfiedNDWffTree = this.satisfyBiconditional(_tree, _parent);
        } else if (_tree.isExistential()) {
            satisfiedNDWffTree = this.satisfyExistential(_tree, _parent);
        } else if (_tree.isUniversal()) {
            satisfiedNDWffTree = this.satisfyUniversal(_tree, _parent);
        } else {
            satisfiedNDWffTree = this.satisfyDeMorganFOPL(_tree, _parent);
        }

        if (this.findTransposition(_tree, _parent)) {
            return null;
        } else if (this.findConstructiveDilemma(_tree, _parent)) {
            return null;
        } else if (this.findDestructiveDilemma(_tree, _parent)) {
            return null;
        } else if (this.findDoubleNegations(_tree, _parent)) {
            return null;
        }

        // If we couldn't find anything to deduce/reduce the proposition with,
        // try to search for it in the premises list.
        for (NDWffTree ndWffTree : this.premisesList) {
            if (ndWffTree.getWffTree().stringEquals(_tree)) {
                return ndWffTree;
            }
        }

        return satisfiedNDWffTree;
    }

    /**
     * A predicate is satisfied if it meets one of the following properties:
     * 1. It already exists as a premise.
     * 2. If, as a quantifier, there exists a premise that matches it
     *    this implies (x)Pxx matches with Paa.
     *
     * @param _tree - WffTree predicate to match against.
     * @param _parent - parent node.
     * @return NDWffTree that is satisfied if we could satisfy _tree, null otherwise.
     */
    private NDWffTree satisfyPredicate(WffTree _tree, NDWffTree _parent) {
        // First, check to see if the premise is a satisfied goal or not.
        if (this.isGoal(_tree)) {
            return this.getPremiseNDWffTree(_tree);
        }

        // Loop through each other premise.
        for (NDWffTree othNDWffTree : this.premisesList) {
            if (_tree.getNodeType() == othNDWffTree.getWffTree().getNodeType()
                    && _tree.getSymbol().equals(othNDWffTree.getWffTree().getSymbol())) {
                // If the two are negated, then we need to truncate it.
                WffTree w1 = _tree.isNegation() ? _tree.getChild(0) : _tree;
                WffTree w2 = othNDWffTree.getWffTree().isNegation() ? othNDWffTree.getWffTree().getChild(0)
                        : othNDWffTree.getWffTree();
                if (w1.getChildrenSize() == w2.getChildrenSize()) {
                    // Now check to see if the children are the same OR
                    // if the former is a matching variable while the latter is a constant.
                    boolean found = true;
                    for (int i = 0; i < w1.getChildrenSize() && found; i++) {
                        WffTree ch1 = w1.getChild(i);
                        WffTree ch2 = w2.getChild(i);
                        if (ch1.stringEquals(ch2) || (ch1.isVariable() && ch2.isConstant())) {
                            continue;
                        } else {
                            found = false;
                        }
                    }
                    if (found) {
                        return othNDWffTree;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Satisfying an implication nodes comes through for primary methods:
     * <p>
     * 1. Modus Ponens (P -> Q), P therefore Q
     * 2. Modus Tollens (P -> Q), ~Q therefore ~P
     * 3. Hypothetical Syllogism (P->Q), (Q->R) therefore (P->R)
     * 4. Construction of (P -> Q) from P and Q.
     *
     * @param _impTree - implication node to check for satisfaction.
     * @param _parent  - parent NDWffTree.
     * @return true if we can satisfy the implication goal, false otherwise.
     */
    private NDWffTree satisfyImplication(WffTree _impTree, NDWffTree _parent) {
        // If the parent is not the conclusion then we can attempt to do other rules on it.
        if (!this.isConclusion(_parent) && _impTree.stringEquals(_parent.getWffTree())) {
            boolean mt = this.findModusTollens(_impTree, _parent);
            boolean mp = this.findModusPonens(_impTree, _parent);
            boolean hs = this.findHypotheticalSyllogism(_impTree, _parent);
            if (mt || mp || hs) return null;
        }

        // Otherwise, try to construct an implication node - see if both sides are satisfiable.
        NDWffTree lhsNDWffTree = this.satisfy(_impTree.getChild(0), _parent);
        NDWffTree rhsNDWffTree = this.satisfy(_impTree.getChild(1), _parent);
        if (lhsNDWffTree != null && rhsNDWffTree != null) {
            ImpNode impNode = new ImpNode(_impTree.getChild(0), _impTree.getChild(1));
            NDWffTree impNDWffTree = new NDWffTree(impNode, NDFlag.II, NDStep.II,
                    this.getPremiseNDWffTree(_impTree.getChild(0)),
                    this.getPremiseNDWffTree(_impTree.getChild(1)));
            this.addPremise(impNDWffTree);
            return impNDWffTree;
        }

        // Finally, check to see if this wff is a premise somewhere.
        return null;
    }

    /**
     * Creates or eliminates a conjunction node. The creation comes through searching for
     * the two operands to see if they exist and if so, create the conjunction. There are
     * four preconditions:
     *
     * @param _conjTree - conjunction node.
     * @param _parent   - parent of conjunction node.
     * @return true if we can satisfy the conjunction goal, false otherwise.
     * @precondition The parent cannot be a conjunction node that previously eliminated a conjunction.
     * @precondition The parent cannot be a conjunction node that introduced a conjunction.
     * @precondition The parent cannot be the conclusion.
     * @precondition _conjTree must represent the same WffTree as _parent.
     * <p>
     * Elimination is simply simplification - breaks the two operands down.
     */
    private NDWffTree satisfyConjunction(WffTree _conjTree, NDWffTree _parent) {
        if (!_parent.isAndEActive() && !_parent.isAndIActive()
                && !this.isConclusion(_parent) && _conjTree.stringEquals(_parent.getWffTree())) {
            if (this.findSimplification(_conjTree, _parent)) return null;
        }

        NDWffTree lhs = this.satisfy(_conjTree.getChild(0), _parent);
        NDWffTree rhs = this.satisfy(_conjTree.getChild(1), _parent);
        if (lhs != null && rhs != null) {
            AndNode andNode = new AndNode(lhs.getWffTree(), rhs.getWffTree());
            NDWffTree andNDWffTree = new NDWffTree(andNode, NDFlag.AI, NDStep.AI, lhs, rhs);
            this.addPremise(andNDWffTree);
            return andNDWffTree;
        }
        return null;
    }

    /**
     * Attempts to satisfy a disjunction for FOPL. There are two preconditions:
     *
     * @param _disjTree - disjunction node.
     * @param _parent   - parent of the disjunction.
     * @return NDWffTree of a disjunction creation if we satisfied the goal of
     * both operands, null otherwise.
     * @precondition _parent cannot be the conclusion.
     * @precondition _disjTree must be the same WffTree as the _parent's.
     * <p>
     * A disjunction is satisfied either through disjunctive syllogism OR
     * through the creation of a disjunction. Creations are satisfied via
     * the satisfaction of one or both of their children. More details are
     * outlined below.
     */
    private NDWffTree satisfyDisjunction(WffTree _disjTree, NDWffTree _parent) {
        // First try to perform DS if the root is a disjunction.
        if (!this.isConclusion(_parent) && _disjTree.stringEquals(_parent.getWffTree())) {
            if (this.findDisjunctiveSyllogism(_disjTree, _parent)) return null;
        }

        // Then try to create a disjunction if it's a goal and one of the two children are satisfied.
        NDWffTree lhsNDWffTree = this.satisfy(_disjTree.getChild(0), _parent);
        NDWffTree rhsNDWffTree = this.satisfy(_disjTree.getChild(1), _parent);
        if (lhsNDWffTree != null || rhsNDWffTree != null) {
            // There's two conditions: we're either adding from the conclusion or from
            // another premise. If the parent is the conclusion, then we're adding from
            // that (obviously) and one of the nodes won't be retrievable via getPremise....
            OrNode orNode = new OrNode(_disjTree.getChild(0), _disjTree.getChild(1));

            // Find out which operand is null (if any).
            NDWffTree lhsDisj = this.getPremiseNDWffTree(_disjTree.getChild(0));
            NDWffTree rhsDisj = this.getPremiseNDWffTree(_disjTree.getChild(1));
            if (this.isConclusion(_parent)) {
                if (lhsDisj == null) {
                    lhsDisj = new NDWffTree(_disjTree.getChild(0), NDStep.OI);
                } else {
                    rhsDisj = new NDWffTree(_disjTree.getChild(1), NDStep.OI);
                }
            }

            NDWffTree orNDWffTree = new NDWffTree(orNode, NDFlag.OI, NDStep.OI, lhsDisj, rhsDisj);
            this.addPremise(orNDWffTree);
            return orNDWffTree;
        }
        return null;
    }

    /**
     * Attempts to satisfy a biconditional. There are two preconditions:
     *
     * @param _bicondTree - biconditional WffTree
     * @param _parent     - parent of _bicondTree.
     * @return NDWffTree of biconditional node if one was created, null otherwise.
     * @precondition _parent cannot be the conclusion.
     * @precondition _bicondTree must represent the same tree as _parent.
     * <p>
     * A biconditional is satisfied via either a BCB rule, or the creation of
     * a biconditional via two implications conjoined with &.
     */
    private NDWffTree satisfyBiconditional(WffTree _bicondTree, NDWffTree _parent) {
        // First check to see if we can break any biconditionals down.
        if (!this.isConclusion(_parent) && _bicondTree.stringEquals(_parent.getWffTree())) {
            if (this.findBiconditionalElimination(_bicondTree, _parent)) {
                return null;
            }
        }
        // We first have a subgoal of X -> Y and Y -> X.
        ImpNode impLhs = new ImpNode(_bicondTree.getChild(0), _bicondTree.getChild(1));
        ImpNode impRhs = new ImpNode(_bicondTree.getChild(1), _bicondTree.getChild(0));

        // Check to see if both implications are satisfied.
        NDWffTree lhsNDWffTree = this.satisfy(impLhs, _parent);
        NDWffTree rhsNDWffTree = this.satisfy(impRhs, _parent);
        if (lhsNDWffTree != null && rhsNDWffTree != null) {
            BicondNode bicondNode = new BicondNode(_bicondTree.getChild(0), _bicondTree.getChild(1));
            NDWffTree bicondNDWffTree = new NDWffTree(bicondNode, NDFlag.BC, NDStep.BCI,
                    this.getPremiseNDWffTree(impLhs),
                    this.getPremiseNDWffTree(impRhs));
            this.addPremise(bicondNDWffTree);
            return bicondNDWffTree;
        }
        return null;
    }

    /**
     * Attempts to satisfy an existential quantifier. There are two preconditions:
     *
     * @param _exisTree - existential node.
     * @param _parent   - parent of existential node.
     * @return NDWffTree if we created one, null if we either added a constant or didn't.
     * @precondition _parent must not be the conclusion.
     * @precondition _exisTree must represent the same WffTree that _parent does.
     * <p>
     * If we haven't decomposed this existential, we can try that first. Otherwise, we
     * will see if we can create an existential from a predicate Pa for some constant a
     * to generate (Ex)Px.
     */
    private NDWffTree satisfyExistential(WffTree _exisTree, NDWffTree _parent) {
        // Try to eliminate the existential if it's not a conclusion.
        if (!this.isConclusion(_parent) && !_parent.isExisActive() && _exisTree.stringEquals(_parent.getWffTree())) {
            this.addExistentialConstant(_parent, ((ExistentialQuantifierNode) _parent.getWffTree()).getVariableSymbolChar());
            return null;
        }

        // If we find a satisfiable NDWffTree, then we can add it.
        NDWffTree child = this.satisfy(_exisTree.getChild(0), _parent);
        if (child != null) {
            String v = ((ExistentialQuantifierNode) _exisTree).getVariableSymbol();
            ExistentialQuantifierNode existentialQuantifierNode = new ExistentialQuantifierNode(v);
            existentialQuantifierNode.addChild(_exisTree.getChild(0));
            NDWffTree existentialNDWffTree = new NDWffTree(existentialQuantifierNode, NDFlag.EX, NDStep.EI, child);
            this.addPremise(existentialNDWffTree);
            return existentialNDWffTree;
        }

        return null;
    }

    /**
     * @param _univTree
     * @param _parent
     * @return
     */
    private NDWffTree satisfyUniversal(WffTree _univTree, NDWffTree _parent) {
        // Try to eliminate the universal if it's not a conclusion.
        if (!this.isConclusion(_parent) && !_parent.isUnivActive() && _univTree.stringEquals(_parent.getWffTree())) {
            this.addUniversalConstants(_parent, ((UniversalQuantifierNode) _parent.getWffTree()).getVariableSymbolChar());
            return null;
        }

        // If we find a satisfiable NDWffTree, then we can add it.
        NDWffTree child = this.satisfy(_univTree.getChild(0), _parent);
        if (child != null) {
            String v = ((UniversalQuantifierNode) _univTree).getVariableSymbol();
            UniversalQuantifierNode universalQuantifierNode = new UniversalQuantifierNode(v);
            universalQuantifierNode.addChild(_univTree.getChild(0));
            NDWffTree universalNDWffTree = new NDWffTree(universalQuantifierNode, NDFlag.UN, NDStep.UI, child);
            this.addPremise(universalNDWffTree);
            return universalNDWffTree;
        }

        return null;
    }

    /**
     * @param _binopTree
     * @param _parent
     * @return
     */
    private NDWffTree satisfyDeMorganFOPL(WffTree _binopTree, NDWffTree _parent) {
        if (!this.isConclusion(_parent) && !_parent.isDEMActive()) {
            WffTree deMorganNode = null;
            // Negate a biconditional to get ~(X <-> Y) => ~((X->Y) & (Y->X)).
            if (_binopTree.isNegation() && _binopTree.getChild(0).isBicond()) {
                ImpNode lhs = new ImpNode(_binopTree.getChild(0).getChild(0), _binopTree.getChild(0).getChild(1));
                ImpNode rhs = new ImpNode(_binopTree.getChild(0).getChild(1), _binopTree.getChild(0).getChild(0));
                AndNode and = new AndNode(lhs, rhs);
                deMorganNode = new NegNode(and);
            }
            // "Unnegate" a conjunction with two implications to get the negated biconditional.
            else if (_binopTree.isNegation() && _binopTree.getChild(0).isAnd()
                    && _binopTree.getChild(0).getChild(0).isImp() && _binopTree.getChild(0).getChild(1).isImp()
                    && _binopTree.getChild(0).getChild(0).getChild(0).stringEquals(_binopTree.getChild(0).getChild(1).getChild(1))
                    && _binopTree.getChild(0).getChild(0).getChild(1).stringEquals(_binopTree.getChild(0).getChild(1).getChild(0))) {
                BicondNode bicondNode = new BicondNode(_binopTree.getChild(0).getChild(0).getChild(0),
                        _binopTree.getChild(0).getChild(0).getChild(1));
                deMorganNode = new NegNode(bicondNode);
            }
            // Four types: one is ~(X B Y) => (~X ~B ~Y)
            else if (_binopTree.isNegation() && (_binopTree.getChild(0).isOr() || _binopTree.getChild(0).isAnd() || _binopTree.getChild(0).isImp())) {
                deMorganNode = BaseTruthTreeGenerator.getNegatedBinaryNode(_binopTree.getChild(0)); // B
                deMorganNode.addChild(_binopTree.getChild(0).isImp() ? _binopTree.getChild(0).getChild(0)
                        : BaseTruthTreeGenerator.getFlippedNode(_binopTree.getChild(0).getChild(0))); // LHS X
                deMorganNode.addChild(BaseTruthTreeGenerator.getFlippedNode(_binopTree.getChild(0).getChild(1))); // RHS Y
            }
            // Other is (X B Y) => ~(~X ~B ~Y)
            else if ((_binopTree.isOr() || _binopTree.isAnd() || _binopTree.isImp())) {
                WffTree negBinaryNode = BaseTruthTreeGenerator.getNegatedBinaryNode(_binopTree); // B
                negBinaryNode.addChild(_binopTree.isImp() ? _binopTree.getChild(0) : BaseTruthTreeGenerator.getFlippedNode(_binopTree.getChild(0))); // LHS X
                negBinaryNode.addChild(BaseTruthTreeGenerator.getFlippedNode(_binopTree.getChild(1))); // RHS Y
                deMorganNode = new NegNode(negBinaryNode);
            }
            // Other turns ~(x)W to (Ex)~W
            else if (_binopTree.isNegation() && _binopTree.getChild(0).isUniversal()) {
                String v = ((UniversalQuantifierNode) _binopTree.getChild(0)).getVariableSymbol();
                ExistentialQuantifierNode existentialQuantifierNode = new ExistentialQuantifierNode(v);
                NegNode neg = new NegNode();
                neg.addChild(_binopTree.getChild(0).getChild(0));
                existentialQuantifierNode.addChild(neg);
                deMorganNode = existentialQuantifierNode;
            }
            // Last turns ~(Ex)W to (x)~W
            else if (_binopTree.isNegation() && _binopTree.getChild(0).isExistential()) {
                String v = ((ExistentialQuantifierNode) _binopTree.getChild(0)).getVariableSymbol();
                UniversalQuantifierNode universalQuantifierNode = new UniversalQuantifierNode(v);
                NegNode neg = new NegNode();
                neg.addChild(_binopTree.getChild(0).getChild(0));
                universalQuantifierNode.addChild(neg);
                deMorganNode = universalQuantifierNode;
            }
            // If we found a node, then it'll be applied/inserted here.
            if (deMorganNode != null) {
                _parent.setFlags(NDFlag.DEM);
                NDWffTree deMorganNDWffTree = new NDWffTree(deMorganNode, NDFlag.DEM, NDStep.DEM, _parent);
                this.addPremise(deMorganNDWffTree);
                return deMorganNDWffTree;
            }
        }
        return null;
    }

    /**
     * @param _existentialNDWffTree
     * @param _variableToReplace
     */
    private void addExistentialConstant(NDWffTree _existentialNDWffTree, char _variableToReplace) {
        // Find the next available constant to use.
        char constant = 'a';
        while (this.constants.contains(constant) || this.conclusionConstants.contains(constant)) {
            // This could wrap around...
            constant++;
        }

        // Replace all variables found with the constant.
        WffTree _newRoot = _existentialNDWffTree.getWffTree().getChild(0).copy();
        this.replaceSymbol(_newRoot, _variableToReplace, constant, ReplaceType.CONSTANT);
        this.addPremise(new NDWffTree(_newRoot, NDFlag.EX, NDStep.EE, _existentialNDWffTree));
        this.constants.add(constant);
    }

    /**
     * @param _universalNDWffTree
     * @param _variableToReplace
     */
    private void addUniversalConstants(NDWffTree _universalNDWffTree, char _variableToReplace) {
        // Add a default constant if one is not available to the universal quantifier.
        if (this.constants.isEmpty()) {
            this.constants.add('a');
        }
        Set<Character> replaceConstants = FLATUtils.union(this.constants, this.conclusionConstants);

        for (char c : replaceConstants) {
            // Create a copy and replace the selected variable.
            WffTree _newRoot = _universalNDWffTree.getWffTree().getChild(0).copy();
            this.replaceSymbol(_newRoot, _variableToReplace, c, ReplaceType.CONSTANT);
            this.addPremise(new NDWffTree(_newRoot, NDStep.UE, _universalNDWffTree));
        }
    }

    /**
     * Recursively adds all constants found in a WffTree to a HashSet. The constants
     * should be listed as a ConstantNode.
     *
     * @param _tree    - WffTree to recursively check.
     * @param _charSet - HashSet of characters to add the discovered constants to.
     */
    private void addAllConstantsToSet(WffTree _tree, HashSet<Character> _charSet) {
        if (_tree != null && _tree.isConstant()) {
            _charSet.add(_tree.getSymbol().charAt(0));
        }
        for (WffTree child : _tree.getChildren()) {
            this.addAllConstantsToSet(child, _charSet);
        }
    }

    /**
     * Replaces a variable or a constant with a constant node in a WffTree. This is used when performing
     * existential, universal decomposition, or identity decomposition.
     *
     * @param _newRoot         - root of WffTree to modify.
     * @param _symbolToReplace - constant or variable that we want to replace e.g. (x) = x
     * @param _symbol          - symbol to replace _symbolToReplace with.
     * @param _type            - type of node to insert to the tree. This should either be ReplaceType.CONSTANT or ReplaceType.VARIABLE.
     */
    private void replaceSymbol(WffTree _newRoot, char _symbolToReplace, char _symbol, ReplaceType _type) {
        // Since we can replace symbols forever, add a timeout here.
        if (++this.cycles > PredicateNaturalDeductionValidator.timeout) { return; }
        for (int i = 0; i < _newRoot.getChildrenSize(); i++) {
            if (_newRoot.getChild(i).isVariable() || _newRoot.getChild(0).isConstant()) {
                char s = _newRoot.getChild(i).getSymbol().charAt(0);
                if (s == _symbolToReplace) {
                    if (_type == ReplaceType.CONSTANT) {
                        _newRoot.setChild(i, new ConstantNode("" + _symbol));
                    } else if (_type == ReplaceType.VARIABLE) {
                        _newRoot.setChild(i, new VariableNode("" + _symbol));
                    }
                }
            }
            this.replaceSymbol(_newRoot.getChild(i), _symbolToReplace, _symbol, _type);
        }
    }

    /**
     * ReplaceType enum for the replaceSymbols method. More details are found there.
     */
    private enum ReplaceType {
        VARIABLE,
        CONSTANT
    }

    // Getters
    public static int getTimeout() {
        return timeout;
    }

    // Setters
    public static void setTimeout(int timeout) {
        PredicateNaturalDeductionValidator.timeout = timeout;
    }

}