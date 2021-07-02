package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab;

import com.flat.view.viewdata.settings.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.LanguagePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageTab extends Tab {
    private LanguagePane languagePane = new LanguagePane();

    public LanguageTab() {
        super.textProperty().bind(SettingsData.getLanguageTab().textProperty());
        super.setContent(this.languagePane);
    }

}