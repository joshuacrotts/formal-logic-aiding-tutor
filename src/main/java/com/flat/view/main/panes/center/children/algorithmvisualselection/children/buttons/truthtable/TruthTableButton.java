package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable.events.TruthTableButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableButton extends Button {

    public TruthTableButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.TRUTH_TABLE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.TRUTH_TABLE).fontProperty());
        super.setDisable(true);
        super.setMinWidth(110);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new TruthTableButtonPressed());
        });
    }

}