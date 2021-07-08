package com.flat.algorithms.predicate;

import com.flat.models.treenode.WffTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public final class GroundSentenceDeterminer {

    /**
     * WffTree to be used in the ground sentence determiner.
     */
    private final WffTree wffTree;

    public GroundSentenceDeterminer(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * A wff is ground if it contains no variables.
     *
     * @return true if the wff is ground, false otherwise.
     */
    public boolean isGroundSentence() {
        Queue<WffTree> queue = new LinkedList<>();
        queue.add(this.wffTree);

        while (!queue.isEmpty()) {
            WffTree t = queue.poll();
            for (WffTree ch : t.getChildren()) {
                if (ch.isVariable()) {
                    return false;
                }
                queue.add(ch);
            }
        }
        return true;
    }
}
