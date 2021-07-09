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
public final class LogicallyConsistentDeterminer {

    /**
     * Combined WffTree - represents the biconditional of the two nodes.
     */
    private final WffTree combinedTree;

    /**
     * Combined truth tree made from the generator.
     */
    private TruthTree combinedTruthTree;

    public LogicallyConsistentDeterminer(WffTree _wffTreeOne, WffTree _wffTreeTwo) {
        // Construct the combined tree, with a biconditional connecting them.
        BicondNode bicondNode = new BicondNode(_wffTreeOne.getChild(0), _wffTreeTwo.getChild(0));
        this.combinedTree = new WffTree();
        this.combinedTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.combinedTree.addChild(bicondNode);
    }

    /**
     * Two formulas are consistent if there is one model in which they are both true. In other words,
     * if we create a biconditional between the two, and check the consistency branch (where both
     * operands are affirmed), at least one branch is open.
     *
     * @return true if the two formulas are logically consistent, false otherwise.
     */
    public boolean isConsistent() {
        BaseTruthTreeGenerator truthTreeGenerator;
        if (this.combinedTree.isPropositionalWff()) {
            truthTreeGenerator = new PropositionalTruthTreeGenerator(this.combinedTree);
        } else {
            truthTreeGenerator = new PredicateTruthTreeGenerator(this.combinedTree);
        }

        this.combinedTruthTree = truthTreeGenerator.getTruthTree();
        TruthTree consistentTree = truthTreeGenerator.getTruthTree().getLeft();
        TruthTree inconsistentTree = truthTreeGenerator.getTruthTree().getRight();

        // The consistency branch must have at least one open branch.
        return new OpenTreeDeterminer(inconsistentTree).hasSomeOpen();
    }

    public WffTree getCombinedTree() {
        return this.combinedTree;
    }

    public TruthTree getCombinedTruthTree() {
        return this.combinedTruthTree;
    }
}
