package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.JsonAdvanceTab;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.AdvancePane;
import javafx.scene.control.Tab;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceTab extends Tab {
    private AdvancePane advancePane = new AdvancePane();

    public AdvanceTab () {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(JsonAdvanceTab.class, JsonAdvanceTab.Keys.ADVANCE).textProperty());
        super.setContent(this.advancePane);
    }

}