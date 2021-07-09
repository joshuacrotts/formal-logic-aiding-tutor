package com.flat.algorithms.predicate;

import com.flat.models.treenode.QuantifierNode;
import com.flat.models.treenode.VariableNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public final class BoundVariableDetector {

    /**
     * WffTree to use in the bound variable detector.
     */
    private final WffTree wffTree;

    public BoundVariableDetector(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    /**
     * Gets a list of all bound variables in the WffTree recursively. A variable is
     * bound if there exists a quantifier that binds it in its scope.
     *
     * @return ArrayList<WffTree> of all bound variables.
     */
    public ArrayList<WffTree> getBoundVariables() {
        ArrayList<WffTree> S = new ArrayList<>();
        Stack<WffTree> L = new Stack<>();
        this.bound(this.wffTree, S, L);
        return S;
    }

    /**
     * @param T
     * @param S
     * @param L
     */
    private void bound(WffTree T, ArrayList<WffTree> S, Stack<WffTree> L) {
        // Quantifiers are always the left-most child in a tree if they exist.
        if (T.isQuantifier()) {
            L.push(T);
        } else if (T.isVariable()) {
            // Once we find a variable, we need to check and see if we have a quantifier
            // that binds it.
            VariableNode tv = (VariableNode) T;
            for (WffTree v : L) {
                QuantifierNode qn = (QuantifierNode) v;
                if (qn.getVariableSymbol().equals(tv.getSymbol())) {
                    S.add(T);
                    break;
                }
            }
        }

        // Pre-order bind variables.
        for (WffTree ch : T.getChildren()) {
            this.bound(ch, S, L);
        }

        if (T.isQuantifier()) {
            L.pop();
        }
    }
}
