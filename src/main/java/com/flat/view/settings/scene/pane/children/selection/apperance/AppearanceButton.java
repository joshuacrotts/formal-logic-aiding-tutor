package com.flat.view.settings.scene.pane.children.selection.apperance;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.appearance.AppearanceTabData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceButton extends Button {

    public AppearanceButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AppearanceTabData.class, AppearanceTabData.Keys.APPEARANCE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AppearanceTabData.class, AppearanceTabData.Keys.APPEARANCE).fontProperty());
        super.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

}