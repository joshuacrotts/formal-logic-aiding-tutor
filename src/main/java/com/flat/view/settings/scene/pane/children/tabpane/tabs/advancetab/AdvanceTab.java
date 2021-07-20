package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.AdvancePane;
import com.flat.view.data.settings.SettingsData;
import javafx.scene.control.Tab;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceTab extends Tab {
    private AdvancePane advancePane = new AdvancePane();

    public AdvanceTab () {
        super.textProperty().bind(SettingsData.getAdvanceTab().textProperty());
        super.setContent(this.advancePane);
    }

}