package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree.events.ParseTreeButtonPressed;
import com.flat.view.data.fx.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeButton extends Button {

    public ParseTreeButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisOnAction();
    }

    private void setThisFx () {
        super.setText("Parse Tree");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            Controller.getEVENT_BUS().throwEvent(new ParseTreeButtonPressed());
        });
    }

}