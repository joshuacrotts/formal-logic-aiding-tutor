package com.flat.view.settings.scene.pane.children.tabpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.AdvanceTab;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.AppearanceTab;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.LanguageTab;
import javafx.geometry.Side;
import javafx.scene.control.TabPane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsTabPane extends TabPane {
    private final AppearanceTab appearanceTab = new AppearanceTab();
    private final LanguageTab languageTab = new LanguageTab();
    private final AdvanceTab advanceTab = new AdvanceTab();

    public SettingsTabPane() {
        this.setFxProperties();
        super.getTabs().addAll(this.appearanceTab, this.languageTab, this.advanceTab);
    }

    private void setFxProperties() {
        super.setSide(Side.LEFT);
        super.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

}