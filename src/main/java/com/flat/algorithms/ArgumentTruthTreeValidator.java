package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.AndNode;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public final class ArgumentTruthTreeValidator {

    /**
     * Each WffTree from the original list is combined via conjunctions with the last
     * being negated, acting as the conclusion.
     */
    private final WffTree combinedTree;

    /**
     * TruthTreeGenerator object to use later.
     */
    private BaseTruthTreeGenerator truthTreeGenerator;

    public ArgumentTruthTreeValidator(ArrayList<WffTree> _wffTreeList) {
        this.combinedTree = new WffTree();
        Stack<WffTree> nodes = new Stack<>();

        // Construct the truth tree by stacking all premises and the negated conclusion.
        for (int i = 0; i < _wffTreeList.size() - 1; i++) {
            nodes.push(_wffTreeList.get(i).getChild(0));
            // If we have two nodes, pop them and perform a conjunction.
            if (nodes.size() == 2) {
                WffTree ch2 = nodes.pop();
                WffTree ch1 = nodes.pop();
                nodes.push(new AndNode(ch1, ch2));
            }
        }

        // Finally, negate the conclusion and add it. Create an AND between the negated
        // conclusion and the rest of the premises.
        AndNode and = new AndNode();
        NegNode neg = new NegNode();
        neg.addChild(_wffTreeList.get(_wffTreeList.size() - 1).getChild(0));
        and.addChild(nodes.pop());
        and.addChild(neg);
        this.combinedTree.addChild(and);

        // Set the flags to make sure that the combined tree knows whether it's a propositional or FOPL formula.
        this.combinedTree.setFlags(_wffTreeList.get(0).getFlags());

        // Get the truth tree generator ready because we're gonna use it.
        if (this.combinedTree.isPropositionalWff()) {
            this.truthTreeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            this.truthTreeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }
    }

    /**
     * A wff is deductively valid if and only if, when we run the truth tree, all branches close. The truth tree
     * is constructed as a series of conjunctions between all premises, followed by a conjunction with a negated
     * conclusion. Example:
     * <p>
     * (A & (B & (C & D))) & ~E)
     * <p>
     * Where A, B, C, and D are wffs that represent premises, and E is a wff that represents a conclusion.
     *
     * @return true if the formula is valid, false otherwise.
     */
    public boolean isValid() {
        if (this.combinedTree.isPropositionalWff()) {
            this.truthTreeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            this.truthTreeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        ClosedTreeDeterminer closedTreeDeterminer = new ClosedTreeDeterminer(this.truthTreeGenerator.getTruthTree());
        return closedTreeDeterminer.hasAllClosed();
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTreeGenerator.getTruthTree();
    }
}
