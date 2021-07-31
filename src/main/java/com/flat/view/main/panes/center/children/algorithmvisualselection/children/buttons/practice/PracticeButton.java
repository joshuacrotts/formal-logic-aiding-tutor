package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.practice;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.practice.events.PracticeButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeButton extends Button {

    public PracticeButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx () {
        super.setText("Practice");
        super.setDisable(true);
        super.setMinWidth(110);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new PracticeButtonPressed());
        });
    }

}