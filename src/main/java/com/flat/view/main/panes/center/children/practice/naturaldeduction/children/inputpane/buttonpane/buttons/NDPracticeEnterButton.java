package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NDPracticeEnterButton extends Button {

    public NDPracticeEnterButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Enter");
        super.setMinWidth(100);
        super.setDisable(true);
    }

}