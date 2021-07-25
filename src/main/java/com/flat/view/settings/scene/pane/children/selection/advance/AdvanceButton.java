package com.flat.view.settings.scene.pane.children.selection.advance;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.AdvanceTabData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceButton extends Button {

    public AdvanceButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceTabData.class, AdvanceTabData.Keys.ADVANCE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceTabData.class, AdvanceTabData.Keys.ADVANCE).fontProperty());
        super.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

}