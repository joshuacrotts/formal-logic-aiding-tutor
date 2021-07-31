package com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.attributes;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNodeText extends Text {

    public TreeNodeText () {
    }

    public TreeNodeText (String _string) {
        super(_string);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        VBox.setMargin(this, new Insets(5));
        super.getStyleClass().removeAll(super.getStyleClass());
        super.getStyleClass().add("fxTreeNodeText");
    }

}