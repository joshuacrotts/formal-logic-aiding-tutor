package com.flat.view.main.panes.center.children.trees.wrappers;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author christopherbrantley
 */
public class VBoxCenterWrapper extends VBox {

    public VBoxCenterWrapper () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setAlignment(Pos.CENTER);
    }

}