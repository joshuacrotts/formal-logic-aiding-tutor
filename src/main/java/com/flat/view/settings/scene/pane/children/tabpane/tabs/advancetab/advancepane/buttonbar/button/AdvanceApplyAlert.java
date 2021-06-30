package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar.button;

import com.flat.models.TimeoutManager;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AdvanceApplyAlert extends Alert {

    public AdvanceApplyAlert (AlertType _alertType, Window _window) {
        super(_alertType);
        super.initModality(Modality.APPLICATION_MODAL);
        super.initOwner(_window);
        this.setContent();
        this.centerOnStage();
    }

    private void setContent () {
        if (super.getAlertType().equals(AlertType.ERROR)) {
            super.setHeaderText("");
            super.setContentText("Please ensure values are within " + TimeoutManager.getMinValue() + " and " + TimeoutManager.getMaxValue() + ".");
        }
        else {
            super.setHeaderText("");
            super.setContentText("Timeout values were updated.");
        }
    }

    private void centerOnStage () {
        super.setX(((Stage)super.getOwner()).getX() + ((((Stage)super.getOwner()).getWidth() - super.getWidth()) / 2));
        super.setY(((Stage)super.getOwner()).getY() + ((((Stage)super.getOwner()).getHeight() - super.getHeight()) / 2));
    }

}