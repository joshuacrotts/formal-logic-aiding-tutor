package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.content.alert.AdvanceAlert;
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
            super.titleProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceAlert.class, AdvanceAlert.Keys.ERROR).textProperty());
            super.setHeaderText("");
            super.contentTextProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceAlert.class, AdvanceAlert.Keys.ERROR_TEXT).textProperty());
        }
        else {
            super.titleProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceAlert.class, AdvanceAlert.Keys.MESSAGE).textProperty());
            super.setHeaderText("");
            super.contentTextProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceAlert.class, AdvanceAlert.Keys.MESSAGE_TEXT).textProperty());
        }
        ((Button)super.getDialogPane().lookupButton(ButtonType.OK)).textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceAlert.class, AdvanceAlert.Keys.OK).textProperty());
    }

    private void centerOnStage () {
        super.setX(((Stage)super.getOwner()).getX() + ((((Stage)super.getOwner()).getWidth() - super.getWidth()) / 2));
        super.setY(((Stage)super.getOwner()).getY() + ((((Stage)super.getOwner()).getHeight() - super.getHeight()) / 2));
    }

}