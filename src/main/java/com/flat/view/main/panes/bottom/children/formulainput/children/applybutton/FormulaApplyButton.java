package com.flat.view.main.panes.bottom.children.formulainput.children.applybutton;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.bottom.children.formulainput.children.applybutton.events.FormulaApplyButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaApplyButton extends Button {

    public FormulaApplyButton () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.APPLY).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.APPLY).fontProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new FormulaApplyButtonPressed());
        });
    }

}