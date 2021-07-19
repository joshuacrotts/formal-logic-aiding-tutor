package com.flat.view.main.panes.center.children.truthtable.base.tablelayout;

import com.flat.models.treenode.AtomNode;
import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTable {

    private ArrayList <TableHeader> headers = new ArrayList();

    public TruthTable (WffTree _wffTree) {
        this.addAtomHeaders(_wffTree);
        this.addColHeaders(_wffTree, 0, 0);
    }

    /**
     *
     */
    private void addAtomHeaders(WffTree _wffTree) {
        ArrayList<AtomNode> atoms = this.getAtoms(_wffTree);
        atoms.forEach( atomNode -> {
            this.headers.add(new TableHeader(this.headers.size(), atomNode.getSymbol(), atomNode));
        });
    }

    /**
     * Recursively collects all AtomNodes in a tree. The ArrayList is treated as a set.
     *
     * @return new ArrayList of all distinct AtomNodes.
     */
    private ArrayList<AtomNode> getAtoms(WffTree _wffTree) {
        ArrayList<AtomNode> atoms = new ArrayList<>();
        this.getAtomsHelper(_wffTree, atoms);
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

    /**
     *
     * @param _wffTree
     * @param _leftMod
     * @param _rightMod
     */
    private void addColHeaders(WffTree _wffTree, int _leftMod, int _rightMod) {
        switch (_wffTree.getChildrenSize()) {
            case 1:
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addColHeaders(_wffTree.getChildren().get(0), _leftMod, _rightMod);
                break;
            case 2:
                this.addColHeaders(_wffTree.getChildren().get(0), _leftMod + 1, 0);
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addColHeaders(_wffTree.getChildren().get(1), 0, _rightMod + 1);
                break;
            default:
                this.addParentheticalHeaders(_leftMod, "(");
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addParentheticalHeaders(_rightMod, ")");
        }
    }

    /**
     *
     * @param _qty
     * @param _text
     */
    private void addParentheticalHeaders (int _qty, String _text) {
        while (_qty-- > 0)
            this.headers.add(new TableHeader(this.headers.size(), _text));
    }

    // Getters for object's attributes.
    public ArrayList<TableHeader> getHeaders() {
        return headers;
    }

    // Setters for object's attributes.
    public void setHeaders(ArrayList<TableHeader> headers) {
        this.headers = headers;
    }

}
