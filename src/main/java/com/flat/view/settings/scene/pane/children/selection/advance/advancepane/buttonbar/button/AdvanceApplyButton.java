package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.data.settings.Settings;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceApplyButton extends Button {

    public AdvanceApplyButton () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).fontProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
        if (Controller.updateTimeouts())
            new AdvanceApplyAlert(AlertType.INFORMATION, super.getScene().getWindow()).show();
        else
            new AdvanceApplyAlert(AlertType.ERROR, super.getScene().getWindow()).show();
        });
    }

}