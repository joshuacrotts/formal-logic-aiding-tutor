package com.flat.view.main.panes.bottom.children.formulainput.children.solvebutton;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import com.flat.view.main.panes.bottom.children.formulainput.children.solvebutton.events.FormulaSolveButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaSolveButton extends Button {

    public FormulaSolveButton () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.SOLVE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.SOLVE).fontProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new FormulaSolveButtonPressed());
        });
    }

}