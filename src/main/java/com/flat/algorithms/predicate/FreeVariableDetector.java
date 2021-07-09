package com.flat.algorithms.predicate;

import com.flat.models.treenode.QuantifierNode;
import com.flat.models.treenode.VariableNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */
public final class FreeVariableDetector {

    /**
     * WffTree to use in the free variable detector.
     */
    private final WffTree wffTree;

    public FreeVariableDetector(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    /**
     * Returns a list of all free variables in a FOPL formula. A variable is free if
     * there is no quantifier that binds it.
     *
     * @return ArrayList<WffTree> of all VariableNodes that are free.
     */
    public ArrayList<WffTree> getFreeVariables() {
        ArrayList<WffTree> S = new ArrayList<>();
        Stack<WffTree> L = new Stack<>();
        this.free(this.wffTree, S, L);
        return S;
    }

    /**
     * Recursively builds a list of nodes that are free in the Wff.
     *
     * @param T
     * @param S
     * @param L
     */
    private void free(WffTree T, ArrayList<WffTree> S, Stack<WffTree> L) {
        // Quantifiers are always the left-most child in a tree if they exist.
        if (T.isQuantifier()) {
            L.push(T);
        } else if (T.isVariable()) {
            // Once we find a variable, we need to check and make sure NO quantifier binds it.
            VariableNode tv = (VariableNode) T;
            boolean found = false;
            for (WffTree v : L) {
                QuantifierNode qn = (QuantifierNode) v;
                if (qn.getVariableSymbol().equals(tv.getSymbol())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                S.add(T);
            }
        }

        // Pre-order search for free variables.
        for (WffTree ch : T.getChildren()) {
            this.free(ch, S, L);
        }

        if (T.isQuantifier()) {
            L.pop();
        }
    }
}
