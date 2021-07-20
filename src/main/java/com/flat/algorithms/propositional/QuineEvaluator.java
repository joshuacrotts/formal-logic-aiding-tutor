package com.flat.algorithms.propositional;

import com.flat.algorithms.models.QuineTree;
import com.flat.models.treenode.AtomNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;

public class QuineEvaluator {

    private final WffTree wffTree;

    public QuineEvaluator(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * Constructs the root of this QuineTree, which then instantiates its two children.
     */
    public void evaluate() {
        QuineTree root = new QuineTree(this.wffTree, this.wffTree.getAtoms());
    }
}
