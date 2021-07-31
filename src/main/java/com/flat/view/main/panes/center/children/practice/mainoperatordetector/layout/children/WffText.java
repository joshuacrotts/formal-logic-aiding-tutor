package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children;

import com.flat.models.treenode.WffTree;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class WffText extends Text {
    private int index;
    private WffTree wffTree = null;

    public WffText (int _index, String _string) {
        this.index = _index;
        super.setText(_string);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setTextOrigin(VPos.CENTER);
    }

    public WffText (int _index, WffTree _wffTree) {
        this.index = _index;
        this.wffTree = _wffTree;
        super.setText(_wffTree.getSymbol());
        super.setTextAlignment(TextAlignment.CENTER);
        super.setTextOrigin(VPos.CENTER);
    }

    // Getters for object's attributes.
    public int getIndex() {
        return index;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setIndex(int index) {
        this.index = index;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

}