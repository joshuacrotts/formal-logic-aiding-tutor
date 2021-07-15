package com.flat.view.main.panes.center.children.trees.wrappers;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author christopherbrantley
 */
public class HBoxCenterWrapper extends HBox {

    public HBoxCenterWrapper () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setAlignment(Pos.CENTER);
    }

}