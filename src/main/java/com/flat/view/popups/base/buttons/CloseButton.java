package com.flat.view.popups.base.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class CloseButton extends Button {

    public CloseButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getStyleClass().removeAll(super.getStyleClass());
        super.getStyleClass().add("closeButton");
        this.setThisOnAction();
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            ((Stage) super.getScene().getWindow()).close();
        });
    }

}