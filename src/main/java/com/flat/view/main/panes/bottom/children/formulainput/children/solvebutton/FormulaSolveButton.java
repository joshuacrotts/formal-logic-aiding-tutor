package com.flat.view.main.panes.bottom.children.formulainput.children.solvebutton;

import com.flat.controller.Controller;
import com.flat.view.main.panes.bottom.children.formulainput.children.solvebutton.events.FormulaSolveButtonPressed;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaSolveButton extends Button {

    public FormulaSolveButton () {
        super.setText("Solve");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.getEventBus().throwEvent(new FormulaSolveButtonPressed());
        });
    }

}