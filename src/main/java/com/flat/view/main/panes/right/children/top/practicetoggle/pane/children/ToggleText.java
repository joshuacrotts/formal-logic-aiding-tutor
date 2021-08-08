package com.flat.view.main.panes.right.children.top.practicetoggle.pane.children;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ToggleText extends Text {

    public ToggleText () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE_MODE_OFF).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.PRACTICE_MODE_OFF).fontProperty());
    }

}