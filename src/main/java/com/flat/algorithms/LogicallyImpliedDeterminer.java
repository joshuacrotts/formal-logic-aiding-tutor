package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.ImpNode;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class LogicallyImpliedDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final TruthTree truthTree;

    /**
     * The combined tree represents the implication node.
     */
    private final WffTree combinedTree;

    public LogicallyImpliedDeterminer(WffTree _wffTreeOne, WffTree _wffTreeTwo) {
        ImpNode impNode = new ImpNode(_wffTreeOne.getChild(0), _wffTreeTwo.getChild(0));
        this.combinedTree = new WffTree();
        this.combinedTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.combinedTree.addChild(new NegNode(impNode));

        BaseTruthTreeGenerator treeGenerator;
        if (this.combinedTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        this.truthTree = treeGenerator.getTruthTree();
    }

    /**
     * One wff logically implies the other if, when running the TT for (A > B), all branches are closed.
     * In other words, there is no model in which T is true and F is false.
     *
     * @return true if A implies B, false otherwise.
     */
    public boolean isImplied() {
        return new ClosedTreeDeterminer(this.truthTree).hasAllClosed();
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTree;
    }
}
