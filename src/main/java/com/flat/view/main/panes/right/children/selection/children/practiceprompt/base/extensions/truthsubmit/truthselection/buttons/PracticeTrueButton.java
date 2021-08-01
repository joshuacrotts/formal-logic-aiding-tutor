package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.truthselection.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeTrueButton extends Button {

    public PracticeTrueButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Truth");
        super.setMinWidth(50);
    }

}