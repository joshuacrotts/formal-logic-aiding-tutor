package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.JsonAppearanceTab;
import com.flat.view.data.json.MappedText;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.AppearancePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceTab extends Tab {
    private final AppearancePane appearancePane = new AppearancePane();

    public AppearanceTab() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonAppearanceTab.class), MappedText.toKey2(JsonAppearanceTab.Keys.APPEARANCE)).textProperty());
        super.setContent(this.appearancePane);
    }

}