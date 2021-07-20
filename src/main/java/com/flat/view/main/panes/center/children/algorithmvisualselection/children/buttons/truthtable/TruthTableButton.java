package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable.events.TruthTableButtonPressed;
import com.flat.view.data.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableButton extends Button {

    public TruthTableButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx() {
        super.setText("Truth Table");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.getEVENT_BUS().throwEvent(new TruthTableButtonPressed());
        });
    }

}