package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.data.settings.Settings;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvancedApplyButton extends Button {

    public AdvancedApplyButton () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).fontProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
        if (Controller.updateTimeouts())
            new AdvancedApplyAlert(AlertType.INFORMATION, super.getScene().getWindow()).show();
        else
            new AdvancedApplyAlert(AlertType.ERROR, super.getScene().getWindow()).show();
        });
    }

}