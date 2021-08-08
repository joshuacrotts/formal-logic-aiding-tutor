package com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.children;

import com.flat.controller.Controller;
import com.flat.models.data.miscellaneous.ButtonsLabels;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ResultText extends Text {

    public ResultText () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.RESULT).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ButtonsLabels.class, ButtonsLabels.Keys.RESULT).fontProperty());
    }

}