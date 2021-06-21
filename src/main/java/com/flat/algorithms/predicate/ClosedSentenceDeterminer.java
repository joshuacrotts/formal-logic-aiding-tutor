package com.flat.algorithms.predicate;

import com.flat.models.treenode.WffTree;

/**
 *
 */
public final class ClosedSentenceDeterminer {

    /**
     *
     */
    private final WffTree wffTree;

    public ClosedSentenceDeterminer(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * @return
     */
    public boolean isClosedSentence() {
        FreeVariableDetector fvd = new FreeVariableDetector(this.wffTree);
        GroundSentenceDeterminer gsd = new GroundSentenceDeterminer(this.wffTree);
        return fvd.getFreeVariables().isEmpty() && !gsd.isGroundSentence();
    }
}
