package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.appearance.AppearanceTabData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.AppearancePane;
import javafx.scene.control.Tab;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceTab extends Tab {
    private final AppearancePane appearancePane = new AppearancePane();

    public AppearanceTab() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AppearanceTabData.class, AppearanceTabData.Keys.APPEARANCE).textProperty());
        super.setContent(this.appearancePane);
    }

}