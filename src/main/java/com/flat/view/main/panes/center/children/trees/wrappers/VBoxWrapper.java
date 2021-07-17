package com.flat.view.main.panes.center.children.trees.wrappers;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class VBoxWrapper extends VBox {

    public VBoxWrapper () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setAlignment(Pos.CENTER);
        super.setManaged(true);
    }

    public final void setChild (Group _pane) {
        super.getChildren().clear();
        super.getChildren().add(_pane);
    }

}