package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.textfields;

import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class WffTextField extends TextField {

    public WffTextField () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setPromptText("Wff");
    }

}