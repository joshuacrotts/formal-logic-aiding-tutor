package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.view.viewdata.SettingsData;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceApplyButton extends Button {

    public AdvanceApplyButton () {
        super.textProperty().bind(SettingsData.getApply().textProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
        if (Controller.updateTimeouts())
            new AdvanceApplyAlert(AlertType.CONFIRMATION, super.getScene().getWindow()).show();
        else
            new AdvanceApplyAlert(AlertType.ERROR, super.getScene().getWindow()).show();
        });
    }

}