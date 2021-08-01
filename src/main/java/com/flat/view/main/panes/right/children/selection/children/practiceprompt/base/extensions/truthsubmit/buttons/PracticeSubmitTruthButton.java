package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSubmitTruthButton extends Button {

    public PracticeSubmitTruthButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Submit");
    }

}