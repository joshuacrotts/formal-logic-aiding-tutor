package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.language.LanguageTabData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.LanguagePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageTab extends Tab {
    private LanguagePane languagePane = new LanguagePane();

    public LanguageTab() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(LanguageTabData.class, LanguageTabData.Keys.LANGUAGE).textProperty());
        super.setContent(this.languagePane);
    }

}