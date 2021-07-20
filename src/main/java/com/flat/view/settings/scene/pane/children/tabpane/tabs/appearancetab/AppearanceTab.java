package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.JsonAppearanceTab;
import com.flat.view.data.json.KeyedText;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.AppearancePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceTab extends Tab {
    private final AppearancePane appearancePane = new AppearancePane();

    public AppearanceTab() {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonAppearanceTab.class), KeyedText.toKey2(JsonAppearanceTab.Keys.APPEARANCE)).textProperty());
        super.setContent(this.appearancePane);
    }

}