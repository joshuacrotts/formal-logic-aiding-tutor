package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.models.treenode.WffTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public final class OpenTreeDeterminer {

    /**
     * Truth Tree to check.
     */
    private final TruthTree tree;

    public OpenTreeDeterminer(TruthTree _tree) {
        this.tree = _tree;
    }

    public OpenTreeDeterminer(WffTree _tree) {
        if (_tree.isPropositionalWff()) {
            this.tree = new PropositionalTruthTreeGenerator(_tree).getTruthTree();
        } else {
            this.tree = new PredicateTruthTreeGenerator(_tree).getTruthTree();
        }
    }

    /**
     * Determines if every branch is open in a truth tree. This method really isn't used since
     * there is never an instance where an all open tree matters, but it's nice to have.
     *
     * @return true if every branch is open in this truth tree, false otherwise.
     */
    public boolean hasAllOpen() {
        Queue<TruthTree> queue = new LinkedList<>();
        queue.add(this.tree);

        while (!queue.isEmpty()) {
            TruthTree t = queue.poll();
            if (t.isLeafNode() && t.isClosed())
                return false;
            if (t.getLeft() != null) {
                queue.add(t.getLeft());
            }
            if (t.getRight() != null) {
                queue.add(t.getRight());
            }
        }

        return true;
    }

    /**
     * Determines if there is at least one open branch in this truth tree.
     *
     * @return true if so, false otherwise.
     */
    public boolean hasSomeOpen() {
        Queue<TruthTree> queue = new LinkedList<>();
        queue.add(this.tree);

        while (!queue.isEmpty()) {
            TruthTree t = queue.poll();
            if (t.isLeafNode() && !t.isClosed())
                return true;
            if (t.getLeft() != null) {
                queue.add(t.getLeft());
            }
            if (t.getRight() != null) {
                queue.add(t.getRight());
            }
        }

        return false;
    }
}
