package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar.button;

import com.flat.view.viewdata.settings.SettingsData;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceApplyAlert extends Alert {

    public AdvanceApplyAlert (AlertType _alertType, Window _window) {
        super(_alertType);
        super.getDialogPane().styleProperty().bind(_window.getScene().getRoot().styleProperty());
        super.initModality(Modality.APPLICATION_MODAL);
        super.initStyle(StageStyle.UNIFIED);
        super.initOwner(_window);
        this.setContent();
        this.centerOnStage();
    }

    private void setContent () {
        if (super.getAlertType().equals(AlertType.ERROR)) {
            super.titleProperty().bind(SettingsData.getError().textProperty());
            super.setHeaderText("");
            super.contentTextProperty().bind(SettingsData.getErrorText().textProperty());
        }
        else {
            super.titleProperty().bind(SettingsData.getMessage().textProperty());
            super.setHeaderText("");
            super.contentTextProperty().bind(SettingsData.getMessageText().textProperty());
        }
        ((Button)super.getDialogPane().lookupButton(ButtonType.OK)).textProperty().bind(SettingsData.getOk().textProperty());
    }

    private void centerOnStage () {
        super.setX(((Stage)super.getOwner()).getX() + ((((Stage)super.getOwner()).getWidth() - super.getWidth()) / 2));
        super.setY(((Stage)super.getOwner()).getY() + ((((Stage)super.getOwner()).getHeight() - super.getHeight()) / 2));
    }

}