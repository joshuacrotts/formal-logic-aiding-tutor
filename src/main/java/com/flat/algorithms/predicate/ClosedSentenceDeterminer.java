package com.flat.algorithms.predicate;

import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class ClosedSentenceDeterminer {

    /**
     * WffTree to use in the closed sentece determiner.
     */
    private final WffTree wffTree;

    public ClosedSentenceDeterminer(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * A wff is closed if all variables are bound and the sentence is not ground.
     *
     * @return true if the wff is closed, false otherwise.
     */
    public boolean isClosedSentence() {
        FreeVariableDetector fvd = new FreeVariableDetector(this.wffTree);
        GroundSentenceDeterminer gsd = new GroundSentenceDeterminer(this.wffTree);
        return fvd.getFreeVariables().isEmpty() && !gsd.isGroundSentence();
    }
}
