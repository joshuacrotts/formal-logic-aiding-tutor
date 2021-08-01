package com.flat.view.settings.scene.pane.children.selection.advanced;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advanced.AdvancedTabData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvancedButton extends Button {

    public AdvancedButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedTabData.class, AdvancedTabData.Keys.ADVANCE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedTabData.class, AdvancedTabData.Keys.ADVANCE).fontProperty());
        super.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

}