package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffPiece;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffText;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class WffPlainLayout implements WffLayout {
    private ArrayList <WffPiece> pieces = new ArrayList();

    public WffPlainLayout (WffTree _wffTree) {
        this.addWffPieces(_wffTree, 0, 0);
    }

    @Override
    public void addWffPieces (WffTree _wffTree, int _leftMod, int _rightMod) {
        if (_wffTree.isPredicate()) {
            this.addParentheticalWffPiece(_leftMod, "(");
            this.addWffPiece(_wffTree);
            _wffTree.getChildren().forEach(child -> {
                this.addWffPiece(child);
            });
            this.addParentheticalWffPiece(_rightMod, ")");
            return;
        }
        switch (_wffTree.getChildrenSize()) {
            case 1:
                this.addParentheticalWffPiece(_leftMod, "(");
                this.addWffPiece(_wffTree);
                this.addWffPieces(_wffTree.getChildren().get(0), 0, _rightMod);
                break;
            case 2:
                this.addWffPieces(_wffTree.getChildren().get(0), _leftMod + 1, 0);
                this.addWffPiece(_wffTree);
                this.addWffPieces(_wffTree.getChildren().get(1), 0, _rightMod + 1);
                break;
            default:
                this.addParentheticalWffPiece(_leftMod, "(");
                this.addWffPiece(_wffTree);
                this.addParentheticalWffPiece(_rightMod, ")");
        }
    }

    @Override
    public void addWffPiece (WffTree _wffTree) {
        if (_wffTree.isOperator()) {
            WffPiece piece;
            if (_wffTree.isBinaryOp() && !_wffTree.isIdentity()) {
                this.pieces.add(new WffPiece(new WffText(this.pieces.size(), " ")));
                piece = new WffPiece(new WffText(this.pieces.size(), _wffTree));
                this.pieces.add(piece);
                this.pieces.add(new WffPiece(new WffText(this.pieces.size(), " ")));
            }
            else {
                piece = new WffPiece(new WffText(this.pieces.size(), _wffTree));
                this.pieces.add(piece);
            }
        }
        else
            this.pieces.add(new WffPiece(new WffText(this.pieces.size(), _wffTree)));
    }

    @Override
    public void addParentheticalWffPiece (int _qty, String _text) {
        while (_qty-- > 0)
            this.pieces.add(new WffPiece(new WffText(this.pieces.size(), _text)));
    }

    // Getters for object's attributes.
    public ArrayList<WffPiece> getPieces() {
        return pieces;
    }

    // Setters for object's attributes.
    public void setPieces(ArrayList<WffPiece> pieces) {
        this.pieces = pieces;
    }

}