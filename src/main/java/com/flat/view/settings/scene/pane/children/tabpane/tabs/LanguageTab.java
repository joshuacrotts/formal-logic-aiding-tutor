package com.flat.view.settings.scene.pane.children.tabpane.tabs;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.languagepane.LanguagePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageTab extends Tab {
    private final LanguagePane languagePane = new LanguagePane();

    public LanguageTab() {
        super.setText("Language");
        super.setContent(this.languagePane);
    }

}