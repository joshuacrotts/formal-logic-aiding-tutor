package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.BicondNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class LogicallyContraryDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final WffTree combinedTree;

    /**
     * Contrary tree - generated from biconditional of two operands.
     */
    private TruthTree combinedTruthTree;

    public LogicallyContraryDeterminer(WffTree _wffTreeOne, WffTree _wffTreeTwo) {
        // Construct the combined tree, with a biconditional connecting them.
        BicondNode bicondNode = new BicondNode(_wffTreeOne.getChild(0), _wffTreeTwo.getChild(0));
        this.combinedTree = new WffTree();
        this.combinedTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.combinedTree.addChild(bicondNode);
    }

    /**
     * Two formulas are logically contrary if the consistency branch (where the bicond operands are affirmed)
     * is closed, but the inconsistency branch (where the bicond operands are negated) must have at least one
     * branch open. In other words, there is no model where both are true but there's at least one where they
     * are false.
     *
     * @return true if the two formulas are logically contrary, false otherwise.
     */
    public boolean isContrary() {
        BaseTruthTreeGenerator truthTreeGenerator;
        if (this.combinedTree.isPropositionalWff()) {
            truthTreeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            truthTreeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        this.combinedTruthTree = truthTreeGenerator.getTruthTree();
        TruthTree consistentTree = truthTreeGenerator.getTruthTree().getLeft();
        TruthTree inconsistentTree = truthTreeGenerator.getTruthTree().getRight();

        // The consistency branch must close, and the right must have at least one open branch.
        return (new ClosedTreeDeterminer(consistentTree).hasAllClosed())
                && (new OpenTreeDeterminer(inconsistentTree).hasSomeOpen());
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getCombinedTruthTree() {
        return this.combinedTruthTree;
    }
}
