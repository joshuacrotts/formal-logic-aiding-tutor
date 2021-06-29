package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab;

import com.flat.models.fx.FxSettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.LanguagePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageTab extends Tab {
    private LanguagePane languagePane = new LanguagePane();

    public LanguageTab() {
        super.textProperty().bind(FxSettingsData.getLanguage().textProperty());
        super.setContent(this.languagePane);
    }

}