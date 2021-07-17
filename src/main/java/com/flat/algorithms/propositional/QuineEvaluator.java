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
        QuineTree root = new QuineTree(this.wffTree, this.getAtoms());
    }

    /**
     * Recursively collects all AtomNodes in a tree. The ArrayList is treated as a set.
     *
     * @return new ArrayList of all distinct AtomNodes.
     */
    private ArrayList<AtomNode> getAtoms() {
        ArrayList<AtomNode> atoms = new ArrayList<>();
        this.getAtomsHelper(this.wffTree, atoms);
        return atoms;
    }

    /**
     * Recursive helper function for the above.
     *
     * @param _wffTreeNode - WffTree node to check.
     * @param _atoms - ArrayList of AtomNodes to add onto.
     */
    private void getAtomsHelper(WffTree _wffTreeNode, ArrayList<AtomNode> _atoms) {
        if (_wffTreeNode == null) return;
        for (WffTree ch : _wffTreeNode.getChildren()) {
            if (ch.isAtom() && !_atoms.contains(ch)) { _atoms.add((AtomNode) ch); }
            this.getAtomsHelper(ch, _atoms);
        }
    }
}
