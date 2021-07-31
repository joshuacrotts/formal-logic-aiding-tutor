package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.children.submit;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.children.submit.events.PracticeSubmitButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSubmitButton extends Button {

    public PracticeSubmitButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Submit");
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new PracticeSubmitButtonPressed());
        });
    }

}