package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NDPracticeResetButton extends Button {

    public NDPracticeResetButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Reset");
        super.setMinWidth(100);
    }

}