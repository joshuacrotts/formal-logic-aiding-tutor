package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.naturaldeduction;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.naturaldeduction.events.NaturalDeductionButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionButton extends Button {

    public NaturalDeductionButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx () {
        super.setText("Natural Deduction");
        super.setDisable(true);
        super.setMinWidth(110);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new NaturalDeductionButtonPressed());
        });
    }

}