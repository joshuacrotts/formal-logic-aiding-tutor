package com.flat.view.settings.scene.pane.children.buttons;

import com.flat.controller.Controller;
import com.flat.models.json.settings.JsonSettings;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsCloseButton extends Button {

    public SettingsCloseButton() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(JsonSettings.class, JsonSettings.Keys.CLOSE).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(JsonSettings.class, JsonSettings.Keys.CLOSE).fontProperty());
        super.setCancelButton(true);
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            ((Stage) super.getScene().getWindow()).close();
        });
    }

}