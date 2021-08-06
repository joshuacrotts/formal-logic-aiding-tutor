package com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout;

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
        this.addVerticalHeader();
        this.addColHeaders(_wffTree, 0, 0);
    }

    /**
     *
     */
    private void addAtomHeaders(WffTree _wffTree) {
        ArrayList<AtomNode> atoms = _wffTree.getAtoms();
        atoms.forEach( atomNode -> {
            this.headers.add(new TableHeader(this.headers.size(), atomNode.getSymbol(), atomNode));
        });
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
                this.addParentheticalHeaders(_leftMod, TableHeader.Type.PARENTHETICAL_OPEN);
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addColHeaders(_wffTree.getChildren().get(0), 0, _rightMod);
                break;
            case 2:
                this.addColHeaders(_wffTree.getChildren().get(0), _leftMod + 1, 0);
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addColHeaders(_wffTree.getChildren().get(1), 0, _rightMod + 1);
                break;
            default:
                this.addParentheticalHeaders(_leftMod, TableHeader.Type.PARENTHETICAL_OPEN);
                this.headers.add(new TableHeader(this.headers.size(), _wffTree.getSymbol(), _wffTree));
                this.addParentheticalHeaders(_rightMod, TableHeader.Type.PARENTHETICAL_CLOSE);
        }
    }

    /**
     *
     * @param _qty
     * @param _text
     */
    private void addParentheticalHeaders (int _qty, TableHeader.Type _type) {
        while (_qty-- > 0)
            this.headers.add(new TableHeader(this.headers.size(), _type, 0));
    }

    private void addVerticalHeader () {
        TableHeader verticalHeader = new TableHeader(this.headers.size(), TableHeader.Type.VERTICAL, this.headers.get(0).getElements().size());
        this.headers.add(verticalHeader);
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