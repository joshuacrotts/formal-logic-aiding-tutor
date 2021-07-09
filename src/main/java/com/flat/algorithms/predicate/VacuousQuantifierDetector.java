package com.flat.algorithms.predicate;

import com.flat.models.treenode.QuantifierNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public final class VacuousQuantifierDetector {

    /**
     * Predicate wfftree to check.
     */
    private final WffTree wffTree;

    public VacuousQuantifierDetector(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * Returns a list of all vacuous quantifiers. A quantifier is vacuous if it does not bind
     * any variables in its scope.
     *
     * @return ArrayList<WffTree> of all QuantifierNodes that are vacuous.
     */
    public ArrayList<WffTree> getVacuousQuantifiers() {
        ArrayList<WffTree> VQ = new ArrayList<>();
        Stack<QuantifierNode> S = new Stack<>();
        this.getVacuousQuantifiersHelper(this.wffTree, VQ, S);
        return VQ;
    }

    /**
     * @param _tree
     * @param _vacuousQuantifiers
     * @param _stack
     */
    private void getVacuousQuantifiersHelper(WffTree _tree, ArrayList<WffTree> _vacuousQuantifiers,
                                             Stack<QuantifierNode> _stack) {
        // If we find a quantifier, we need to push it to check later. Quantifiers are vacuous
        // until proven otherwise.
        if (_tree.isQuantifier()) {
            _stack.push((QuantifierNode) _tree);
        } else if (_tree.isVariable()) {
            // Once we're on a variable, iterate through the quantifiers to see if there's one that binds it.
            // If so, it is marked as non-vacuous.
            for (QuantifierNode quantifierNode : _stack) {
                if (quantifierNode.getVariableSymbol().equals(_tree.getSymbol())) {
                    quantifierNode.setVacuous(false);
                    return;
                }
            }
        }

        for (WffTree child : _tree.getChildren()) {
            this.getVacuousQuantifiersHelper(child, _vacuousQuantifiers, _stack);
        }

        // After the recursion unwinds, we check to see if the quantifier is still vacuous.
        if (_tree.isQuantifier()) {
            QuantifierNode poppedQuantifier = _stack.pop();
            if (poppedQuantifier.isVacuous()) {
                _vacuousQuantifiers.add(poppedQuantifier);
            }
        }
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }
}
