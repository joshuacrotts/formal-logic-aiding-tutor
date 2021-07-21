package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.language.JsonLanguageTab;
import com.flat.view.data.json.MappedText;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.LanguagePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageTab extends Tab {
    private LanguagePane languagePane = new LanguagePane();

    public LanguageTab() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonLanguageTab.class), MappedText.toKey2(JsonLanguageTab.Keys.LANGUAGE)).textProperty());
        super.setContent(this.languagePane);
    }

}