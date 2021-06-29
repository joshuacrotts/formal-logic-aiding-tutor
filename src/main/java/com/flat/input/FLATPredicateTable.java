package com.flat.input;

import com.flat.models.treenode.PredicateNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public final class FLATPredicateTable {

    /**
     * ArrayList to keep track of the predicates currently in use to make sure that, if we redeclare a predicate,
     * its arity matches one stored (if it exists).
     */
    private final Set<PredicateNode> currentPredicates;

    public FLATPredicateTable() {
        this.currentPredicates = new HashSet<>();
    }

    /**
     * @param _predicateNode
     */
    public void addPredicate(PredicateNode _predicateNode) {
        if (!this.hasPredicate(_predicateNode)) {
            this.currentPredicates.add(_predicateNode);
        }
    }

    /**
     * @param _predicateNode
     * @return
     */
    public boolean hasPredicate(PredicateNode _predicateNode) {
        for (PredicateNode predNode : this.currentPredicates) {
            if (_predicateNode.getPredicateLetter().equals(predNode.getPredicateLetter())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if a previous declaration of this predicate matches the current declaration.
     *
     * @param _predicateNode - predicate node to check against - should NOT be in the AL.
     * @return true if there exists a previous declaration and its arity differs, false otherwise.
     */
    public boolean isDifferent(PredicateNode _predicateNode) {
        for (PredicateNode predNode : this.currentPredicates) {
            if (_predicateNode.getPredicateLetter().equals(predNode.getPredicateLetter())
                    && _predicateNode.getArity() != predNode.getArity()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the arity of a preexisting predicate in the set. This is really only useful for
     * checking the definition that currently exists.
     *
     * @param _predicateNode - predicate node to check against, a version of it SHOULD be in the DB.
     * @return -1 if the predicate does not exist, and the arity of the existing predicate otherwise.
     */
    public int getArity(PredicateNode _predicateNode) {
        for (PredicateNode predNode : this.currentPredicates) {
            if (_predicateNode.getPredicateLetter().equals(predNode.getPredicateLetter())) {
                return predNode.getArity();
            }
        }
        return -1;
    }
}
