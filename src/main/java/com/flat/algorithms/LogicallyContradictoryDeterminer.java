package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.BicondNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

public final class LogicallyContradictoryDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final TruthTree truthTree;

    /**
     * Contradictory tree - generated from biconditional of two operands.
     */
    private final WffTree combinedTree;

    public LogicallyContradictoryDeterminer(WffTree _wffTreeOne, WffTree _wffTreeTwo) {
        BicondNode bicondNode = new BicondNode(_wffTreeOne.getChild(0), _wffTreeTwo.getChild(0));

        this.combinedTree = new WffTree();
        this.combinedTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.combinedTree.addChild(bicondNode);

        BaseTruthTreeGenerator treeGenerator;
        if (this.combinedTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        this.truthTree = treeGenerator.getTruthTree();
    }

    /**
     * Two formulas are logically contradictory if their biconditional has all closed branches.
     *
     * @return true if the two formulas are contradictory, false otherwise.
     */
    public boolean isContradictory() {
        return new ClosedTreeDeterminer(this.truthTree).hasAllClosed();
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTree;
    }
}
