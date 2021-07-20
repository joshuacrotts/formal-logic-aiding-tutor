package com.flat.view.main.panes.bottom.children.formulainput.children.applybutton;

import com.flat.controller.Controller;
import com.flat.view.main.panes.bottom.children.formulainput.children.applybutton.events.FormulaApplyButtonPressed;
import com.flat.view.data.fx.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaApplyButton extends Button {

    public FormulaApplyButton () {
        super.setText("Apply");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.getEVENT_BUS().throwEvent(new FormulaApplyButtonPressed());
        });
    }

}