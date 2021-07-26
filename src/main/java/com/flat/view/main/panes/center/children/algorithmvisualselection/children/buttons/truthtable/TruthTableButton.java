package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable;

import com.flat.controller.Controller;
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
        super.setText("Truth Table");
        super.setDisable(true);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new TruthTableButtonPressed());
        });
    }

}