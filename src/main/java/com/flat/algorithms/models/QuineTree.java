package com.flat.algorithms.models;

import com.flat.FLAT;
import com.flat.models.treenode.*;
import com.flat.tools.FLATUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public final class QuineTree {

    private static final String[] INTERPRETATIONS = {"W", "X", "Y", "Z", "A'", "B'", "C'", "D'", "E'"};

    /**
     * List of AtomNodes to evaluate recursively.
     */
    private ArrayList<AtomNode> atomNodeList;

    /**
     * Original WffTree formula to evaluate.
     */
    private WffTree wffTree;

    /**
     * AtomNode to replace with true or false nodes depending on the interpretation.
     */
    private AtomNode atomNode;

    /**
     * Left quine tree - should use the true interpretation.
     */
    private QuineTree leftQuineTree;

    /**
     * Right quine tree - should use the false interpretation.
     */
    private QuineTree rightQuineTree;

    /**
     * Each QuineTree has either a true or false path - this indicates which path this node took.
     */
    private boolean interpretation;

    /**
     * Current depth of this node in the Quine tree.
     */
    private int depth;

    public QuineTree(WffTree _wffTree, ArrayList<AtomNode> _atomNodeList) {
        this.wffTree = _wffTree;
        this.leftQuineTree = new QuineTree(_wffTree, _atomNodeList, true, 1);
        this.rightQuineTree = new QuineTree(_wffTree, _atomNodeList, false, 1);
    }

    private QuineTree(WffTree _wffTree, ArrayList<AtomNode> _atomNodeList, boolean _interpretation, int _depth) {
        this.wffTree = _wffTree.copy();
        if (!_atomNodeList.isEmpty() && !this.isTerminalNode()) {
            this.atomNodeList = _atomNodeList;
            this.interpretation = _interpretation;
            this.depth = _depth;
            this.atomNode = this.atomNodeList.get(0);
            this.replaceAtoms();
            this.evaluateQuineTree();
        } else {
            this.wffTree = _wffTree;
            this.depth = _depth;
            this.atomNodeList = null;
            this.atomNode = null;
            this.interpretation = false;
        }
    }

    /**
     * Uses Quine's method to evaluate the WffTree. We then construct a list of new, unused atoms
     * to pass down to the two children of this tree.
     */
    private void evaluateQuineTree() {
        this.evaluateWff(this.wffTree);
        ArrayList<AtomNode> newAtoms = this.getNewAtoms();
        this.leftQuineTree = new QuineTree(this.wffTree, newAtoms, true, this.depth + 1);
        this.rightQuineTree = new QuineTree(this.wffTree, newAtoms, false, this.depth + 1);
    }

    /**
     * Uses Quine's method to evaluate this WffTree until it does not have only truth/false
     * nodes OR it is a terminal node.
     *
     * @param _wffTree - wfftree to evaluate.
     */
    private void evaluateWff(WffTree _wffTree) {
        // We want to continuously evaluate the wff if it only has true/false nodes
        // because otherwise we'll end up with statements like this (T -> T) or (F -> F).
        do {
            this.evaluateWffHelper(_wffTree);
        } while ((this.hasTrueFalseNode() || this.hasOnlyTrueFalseNodes()) && !this.isTerminalNode());
    }

    /**
     * Recursively evaluates the WffTree and its chldren via Quine's method.
     *
     * @param _wffTree - child passed in.
     */
    private void evaluateWffHelper(WffTree _wffTree) {
        for (int i = 0; i < _wffTree.getChildrenSize(); i++) {
            WffTree ch = _wffTree.getChild(i);
            if (ch.isAnd()) {
                this.evaluateConjunction(i, _wffTree, ch);
            } else if (ch.isOr()) {
                this.evaluateDisjunction(i, _wffTree, ch);
            } else if (ch.isImp()) {
                this.evaluateImplication(i, _wffTree, ch);
            } else if (ch.isBicond()) {
                this.evaluateBiconditional(i, _wffTree, ch);
            } else if (ch.isNegation()) {
                this.evaluateNegation(i, _wffTree, ch);
            }
            this.evaluateWffHelper(ch);
        }
    }

    /**
     * Evaluates a conjunction node in the tree. Conjunctions are eliminated by both Truth and
     * FalseNodes. If a conjunction has a TruthNode as one of its operands, the conjunction is replaced
     * by the other operand. If the conjunction has a FalseNode as one of its operands, the conjunction
     * is replaced by a FalseNode.
     *
     * @param _idx - index to replace if a conjunction is found that satisfies the above criteria.
     * @param _parent - parent of conjunction node.
     * @param _conjTree - conjunction node itself.
     */
    private void evaluateConjunction(int _idx, WffTree _parent, WffTree _conjTree) {
        if (_conjTree.getChild(0).isTrue()) {
            _parent.setChild(_idx, _conjTree.getChild(1));
        } else if (_conjTree.getChild(1).isTrue()) {
            _parent.setChild(_idx, _conjTree.getChild(0));
        } else if (_conjTree.getChild(0).isFalse()) {
            _parent.setChild(_idx, _conjTree.getChild(0));
        } else if (_conjTree.getChild(1).isFalse()) {
            _parent.setChild(_idx, _conjTree.getChild(1));
        }
    }

    /**
     * Evaluates a disjunction node in the tree. Disjunctions are only eliminated by TruthNodes
     * (they are consumed) and the opposing node is left if there is a FalseNode as one of the operands.
     * For instance, (T || A) => T, (F || C) => C.
     *
     * @param _idx - index to replace if a disjunction is found that satisfies the above criteria.
     * @param _parent - parent of disjunction node.
     * @param _disjTree - disjunction node itself.
     */
    private void evaluateDisjunction(int _idx, WffTree _parent, WffTree _disjTree) {
        if (_disjTree.getChild(0).isTrue()) {
            _parent.setChild(_idx, _disjTree.getChild(0));
        } else if (_disjTree.getChild(1).isTrue()) {
            _parent.setChild(_idx, _disjTree.getChild(1));
        } else if (_disjTree.getChild(0).isFalse()) {
            _parent.setChild(_idx, _disjTree.getChild(1));
        } else if (_disjTree.getChild(1).isFalse()) {
            _parent.setChild(_idx, _disjTree.getChild(0));
        }
    }

    /**
     * Evaluates an implication node in the tree. Implications are only affected by
     * Truth and FalseNodes such that if true implies something, then whatever the consequent
     * is, becomes that node. False implies anything is true so we just replace it with that.
     *
     * @param _idx - index to replace if an implication is found that satisfies the above criteria.
     * @param _parent - parent of implication node.
     * @param _impTree - implication node itself.
     */
    private void evaluateImplication(int _idx, WffTree _parent, WffTree _impTree) {
        // False implies anything is true.
        if (_impTree.getChild(0).isFalse()) {
            _parent.setChild(_idx, new TruthNode());
        }
        // Anything impies true is true or the lhs is true (we do the same thing).
        else if (_impTree.getChild(0).isTrue() || _impTree.getChild(1).isTrue()){
            _parent.setChild(_idx, _impTree.getChild(1));
        }
        // A implies false is ~A
        else if (_impTree.getChild(1).isFalse()) {
            _parent.setChild(_idx, new NegNode(_impTree.getChild(0)));
        }
    }

    /**
     * We can do one of a few things with the biconditional:
     * 1. If we have (P iff P), then that is true.
     * 2. (True iff True) is true.
     * 3. (False iff False) is true.
     * Anything else needs to be broken down into a conjunction of implications
     * .
     * @param _idx
     * @param _parent
     * @param _bicondTree
     */
    private void evaluateBiconditional(int _idx, WffTree _parent, WffTree _bicondTree) {
        // If they are the same then it's true.
        if (_bicondTree.getChild(0).stringEquals(_bicondTree.getChild(1))) {
            _parent.setChild(_idx, new TruthNode());
        } else {
            // Otherwise, replace it with a conjunction of implications.
            WffTree lhs = _bicondTree.getChild(0);
            WffTree rhs = _bicondTree.getChild(1);
            _parent.setChild(_idx, new AndNode(new ImpNode(lhs, rhs), new ImpNode(rhs, lhs)));
        }
    }

    /**
     * Evaluates a negation node in the tree. Negations only affect Truth and FalseNodes,
     * such that TruthNodes become FalseNodes, and vice versa.
     *
     * @param _idx - index to replace if a negation is found on a Truth or FalseNode.
     * @param _parent - parent of negation node.
     * @param _negTree - negation node itself.
     */
    private void evaluateNegation(int _idx, WffTree _parent, WffTree _negTree) {
        if (_negTree.getChild(0).isTrue()) {
            _parent.setChild(_idx, new FalseNode());
        } else if (_negTree.getChild(0).isFalse()) {
            _parent.setChild(_idx, new TruthNode());
        }
    }

    /**
     * Iterates through the wff recursively to replace all atom nodes with either a TruthNode
     * or FalseNode.
     */
    private void replaceAtoms() {
        this.replaceAtomsHelper(this.wffTree);
    }

    /**
     * "New" atoms are all atoms that are not the first element in the current list of atoms. The two
     * leaves of this QuineTree use this to pick which node to further investigate.
     *
     * @return ArrayList of AtomNodes that are new.
     */
    private ArrayList<AtomNode> getNewAtoms() {
        ArrayList<AtomNode> newAtoms = new ArrayList<>();
        for (int i = 1; i < this.atomNodeList.size(); i++) { newAtoms.add(this.atomNodeList.get(i)); }
        return newAtoms;
    }

    /**
     * Recursively replaces all atoms in the WffTree with a TruthNode or FalseNode, depending
     * on the set value of interpretation.
     *
     * @param _wffTree - recursively passed WffTree node.
     */
    private void replaceAtomsHelper(WffTree _wffTree) {
        for (int i = 0; i < _wffTree.getChildrenSize(); i++) {
            WffTree ch = _wffTree.getChild(i);
            if (ch.stringEquals(this.atomNode)) {
                _wffTree.setChild(i, this.interpretation ? new TruthNode() : new FalseNode());
            }

            this.replaceAtomsHelper(ch);
        }
    }

    /**
     * When a tree only has true/false nodes (other than operators), we need to keep iterating through it
     * because that means that we can further simplify it. Otherwise, we could end up in a situation
     * with wffs like (T->T) or something similar.
     *
     * @return true if the tree has only true/false nodes (other than operators), false otherwise.
     */
    private boolean hasOnlyTrueFalseNodes() {
        Queue<WffTree> queue = new LinkedList<>();
        queue.add(this.wffTree);
        while (!queue.isEmpty()) {
            WffTree wff = queue.poll();
            // If the wff is a T/F node then it won't have children, but neither do
            // atoms so we have to make sure it's not true or false before returning false.
            if (wff.getChildren().isEmpty() && !wff.isTrue() && !wff.isFalse()) { return false; }
            queue.addAll(wff.getChildren());
        }

        return true;
    }

    /**
     * If a wff has a true or false value somewhere in it, we want to keep trying to evaluate it.
     *
     * @return true if the formula has a T/F somewhere in it, false otherwise.
     */
    private boolean hasTrueFalseNode() {
        Queue<WffTree> queue = new LinkedList<>();
        queue.add(this.wffTree);
        while (!queue.isEmpty()) {
            WffTree wff = queue.poll();
            if (wff.isTrue() || wff.isFalse()) { return true; }
            queue.addAll(wff.getChildren());
        }

        return false;
    }

    /**
     * Recursively constructs a string representation of the quine tree.
     *
     * @return String representation to output to the console.
     */
    public String printQuineTree() {
        StringBuilder sb = new StringBuilder("(ROOT)" + ", " + this.wffTree.getStringRep() + "\n");
        this.printQuineTreeHelper(this, sb);
        return sb.toString();
    }

    /**
     * Recursively builds a stringbuilder representation of this QuineTree and its children. If the
     * toString() of the QuineTree is null then nothing is added. Otherwise, a new line is appended.
     *
     * @param _quineTree
     */
    private void printQuineTreeHelper(QuineTree _quineTree, StringBuilder sb) {
        if (_quineTree == null) { return; }
        // If the toString() is not null then we can do stuff.
        if (_quineTree.toString() != null) {
            sb.append(FLATUtils.repeatString(_quineTree.depth, " "));
            sb.append(_quineTree);
            sb.append("\n");
        }
        if (_quineTree.getLeftQuineTree() != null) { this.printQuineTreeHelper(_quineTree.getLeftQuineTree(), sb); }
        if (_quineTree.getRightQuineTree() != null) { this.printQuineTreeHelper(_quineTree.getRightQuineTree(), sb); }
    }

    @Override
    public String toString() {
        if (this.depth <= 0 || this.atomNode == null) { return null; }
        // Tabs, I followed by "depth" ticks, (, atom, interpretation, ), formula.
        return String.format("%s(%s/%b), %s", QuineTree.INTERPRETATIONS[this.depth - 1],
                this.atomNode.getStringRep(),
                this.interpretation,
                this.wffTree.getStringRep());
    }

    public WffTree getInterpretationNode() {
        return this.isTerminalNode() ? this.wffTree : null;
    }

    public AtomNode getAtomNode() {
        return this.atomNode;
    }

    public boolean getInterpretation() {
        return this.interpretation;
    }

    public int getDepth() {
        return this.depth;
    }

    private boolean isTerminalNode() {
        return this.wffTree.isRoot()
                && (this.wffTree.getChild(0).isTrue() || this.wffTree.getChild(0).isFalse());
    }

    public QuineTree getLeftQuineTree() {
        return this.leftQuineTree;
    }

    public QuineTree getRightQuineTree() {
        return this.rightQuineTree;
    }
}
