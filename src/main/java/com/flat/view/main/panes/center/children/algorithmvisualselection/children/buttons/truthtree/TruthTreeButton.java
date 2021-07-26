package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree.events.TruthTreeButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreeButton extends Button {

    public TruthTreeButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx () {
        super.setText("Truth Tree");
        super.setDisable(true);
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new TruthTreeButtonPressed());
        });
    }

}