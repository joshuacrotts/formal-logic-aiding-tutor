package com.flat.view.settings.scene.pane.children.buttonbar.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsCloseButton extends Button {

    public SettingsCloseButton () {
        super.setText("Close");
        super.setCancelButton(true);
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction((event) -> {
            ((Stage)super.getScene().getWindow()).close();
        });
    }

}