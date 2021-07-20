package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab;

import com.flat.view.data.settings.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.AppearancePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceTab extends Tab {
    private final AppearancePane appearancePane = new AppearancePane();

    public AppearanceTab() {
        super.textProperty().bind(SettingsData.getAppearanceTab().textProperty());
        super.setContent(this.appearancePane);
    }

}