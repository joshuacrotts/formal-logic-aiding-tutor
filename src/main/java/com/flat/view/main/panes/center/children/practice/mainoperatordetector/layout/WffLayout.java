package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout;

import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.HighlightableWffPiece;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffPiece;
import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffText;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class WffLayout {
    private ArrayList <WffPiece> pieces = new ArrayList();
    private ArrayList <HighlightableWffPiece> highlightablePieces = new ArrayList();

    public WffLayout (WffTree _wffTree) {
        this.addWffPieces(_wffTree, 0, 0);
    }

    private void addWffPieces (WffTree _wffTree, int _leftMod, int _rightMod) {
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

    private void addWffPiece (WffTree _wffTree) {
        if (_wffTree.isOperator()) {
            HighlightableWffPiece piece;
            if (_wffTree.isBinaryOp() && !_wffTree.isIdentity()) {
                this.pieces.add(new WffPiece(new WffText(this.pieces.size(), " ")));
                piece = new HighlightableWffPiece(new WffText(this.pieces.size(), _wffTree));
                this.highlightablePieces.add(piece);
                this.pieces.add(piece);
                this.pieces.add(new WffPiece(new WffText(this.pieces.size(), " ")));
            }
            else {
                piece = new HighlightableWffPiece(new WffText(this.pieces.size(), _wffTree));
                this.highlightablePieces.add(piece);
                this.pieces.add(piece);
            }
        }
        else
            this.pieces.add(new WffPiece(new WffText(this.pieces.size(), _wffTree)));
    }

    private void addParentheticalWffPiece (int _qty, String _text) {
        while (_qty-- > 0)
            this.pieces.add(new WffPiece(new WffText(this.pieces.size(), _text)));
    }

    // Getters for object's attributes.
    public ArrayList<WffPiece> getPieces() {
        return pieces;
    }

    public ArrayList<HighlightableWffPiece> getHighlightablePieces() {
        return highlightablePieces;
    }

    // Setters for object's attributes.
    public void setPieces(ArrayList<WffPiece> pieces) {
        this.pieces = pieces;
    }

    public void setHighlightablePieces(ArrayList<HighlightableWffPiece> highlightablePieces) {
        this.highlightablePieces = highlightablePieces;
    }

}