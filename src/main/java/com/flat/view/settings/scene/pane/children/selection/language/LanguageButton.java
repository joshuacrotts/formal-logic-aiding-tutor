package com.flat.view.settings.scene.pane.children.selection.language;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.language.LanguageTabData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageButton extends Button {

    public LanguageButton () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(LanguageTabData.class, LanguageTabData.Keys.LANGUAGE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(LanguageTabData.class, LanguageTabData.Keys.LANGUAGE).fontProperty());
        super.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

}