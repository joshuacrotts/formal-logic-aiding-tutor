package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.AdvancePane;
import javafx.scene.control.Tab;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AdvanceTab extends Tab {
    private AdvancePane advancePane = new AdvancePane();

    public AdvanceTab () {
        super.setText("Advance");
        super.setContent(this.advancePane);
    }

}