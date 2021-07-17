package com.flat.view.main.panes.center.children.trees.wrappers;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class HBoxWrapper extends HBox {

    public HBoxWrapper () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().add(new VBoxWrapper());
        super.setAlignment(Pos.CENTER);
        super.setManaged(true);
    }

    public final void setChild (Pane _pane) {
        super.getChildren().clear();
        super.getChildren().add(_pane);
    }

}