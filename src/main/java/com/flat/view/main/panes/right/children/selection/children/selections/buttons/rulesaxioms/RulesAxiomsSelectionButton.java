package com.flat.view.main.panes.right.children.selection.children.selections.buttons.rulesaxioms;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.selections.buttons.rulesaxioms.events.RulesAxiomsSelectionButtonPressed;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsSelectionButton extends Button {

    public RulesAxiomsSelectionButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Rules/Axioms");
        super.setMinWidth(80);
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new RulesAxiomsSelectionButtonPressed());
        });
    }

}