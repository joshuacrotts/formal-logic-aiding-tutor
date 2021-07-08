package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class LogicalFalsehoodDeterminer {

    /**
     * TruthTree that is constructed from the generator.
     */
    private final TruthTree truthTree;

    /**
     *
     */
    private final WffTree wffTree;

    public LogicalFalsehoodDeterminer(WffTree _wffTreeOne) {
        this.wffTree = _wffTreeOne.copy();
        BaseTruthTreeGenerator treeGenerator;
        if (this.wffTree.isPropositionalWff()) {
            treeGenerator = new PropositionalTruthTreeGenerator(this.wffTree);
        } else {
            treeGenerator = new PredicateTruthTreeGenerator(this.wffTree);
        }

        this.truthTree = treeGenerator.getTruthTree();
    }

    /**
     * @return
     */
    public boolean isFalsehood() {
        return new ClosedTreeDeterminer(this.truthTree).hasAllClosed();
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    public TruthTree getTruthTree() {
        return this.truthTree;
    }
}
