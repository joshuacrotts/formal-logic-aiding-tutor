package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.AdvanceTabData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.AdvancePane;
import javafx.scene.control.Tab;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceTab extends Tab {
    private AdvancePane advancePane = new AdvancePane();

    public AdvanceTab () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvanceTabData.class, AdvanceTabData.Keys.ADVANCE).textProperty());
        super.setContent(this.advancePane);
    }

}