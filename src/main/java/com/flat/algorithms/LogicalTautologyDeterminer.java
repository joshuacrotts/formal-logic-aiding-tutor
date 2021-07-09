package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.NodeFlag;
import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class LogicalTautologyDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final TruthTree truthTree;

    /**
     * Combined WffTree for determining if the formula is a tautology. Takes the original node
     * and appends a negation.
     */
    private final WffTree wffTree;

    public LogicalTautologyDeterminer(WffTree _wffTreeOne) {
        this.wffTree = new WffTree();
        this.wffTree.setFlags(_wffTreeOne.isPropositionalWff() ? NodeFlag.PROPOSITIONAL : NodeFlag.PREDICATE);
        this.wffTree.addChild(new NegNode());
        this.wffTree.getChild(0).addChild(_wffTreeOne.getChild(0));

        BaseTruthTreeGenerator treeGenerator;
        if (this.wffTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.wffTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.wffTree);
        }

        this.truthTree = treeGenerator.getTruthTree();
    }

    /**
     * A formula is a tautology if its negation is a closed tree.
     *
     * @return true if this formula is a tautology, false otherwise.
     */
    public boolean isTautology() {
        return new ClosedTreeDeterminer(this.truthTree).hasAllClosed();
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTree;
    }
}
