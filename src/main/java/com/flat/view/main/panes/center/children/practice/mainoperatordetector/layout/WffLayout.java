package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffPiece;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public interface WffLayout {

    void addWffPieces (WffTree _wffTree, int _leftMod, int _rightMod);

    void addWffPiece (WffTree _wffTree);

    void addParentheticalWffPiece (int _qty, String _text);

    ArrayList<WffPiece> getPieces();

    void setPieces(ArrayList<WffPiece> pieces);

}