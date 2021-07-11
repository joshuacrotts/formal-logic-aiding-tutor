package com.flat.view.settings.scene.pane.children.buttons;

import com.flat.view.viewdata.settings.SettingsData;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsCloseButton extends Button {

    public SettingsCloseButton() {
        super.textProperty().bind(SettingsData.getClose().textProperty());
        super.setCancelButton(true);
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            ((Stage) super.getScene().getWindow()).close();
        });
    }

}