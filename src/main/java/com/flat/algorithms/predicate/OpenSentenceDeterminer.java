package com.flat.algorithms.predicate;

import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class OpenSentenceDeterminer {

    /**
     * WffTree to use in the open sentence determiner.
     */
    private final WffTree wffTree;

    public OpenSentenceDeterminer(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * A sentence is open if there is at least one free variable.
     *
     * @return true if sentence is open, false otherwise.
     */
    public boolean isOpenSentence() {
        FreeVariableDetector fvd = new FreeVariableDetector(this.wffTree);
        return !fvd.getFreeVariables().isEmpty();
    }
}
