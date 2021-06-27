package com.flat.view.settings.scene.pane.children.tabpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.AppearanceTab;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.LanguageTab;
import javafx.geometry.Side;
import javafx.scene.control.TabPane;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsTabPane extends TabPane {
    private final AppearanceTab appearanceTab = new AppearanceTab();
    private final LanguageTab languageTab = new LanguageTab();

    public SettingsTabPane() {
        this.setFxProperties();
        super.getTabs().addAll(this.appearanceTab, this.languageTab);
    }

    private void setFxProperties() {
        super.setSide(Side.LEFT);
        super.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

}