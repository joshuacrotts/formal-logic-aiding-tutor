package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab;

import com.flat.view.viewdata.settings.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.AppearancePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AppearanceTab extends Tab {
    private final AppearancePane appearancePane = new AppearancePane();

    public AppearanceTab() {
        super.textProperty().bind(SettingsData.getAppearanceTab().textProperty());
        super.setContent(this.appearancePane);
    }

}