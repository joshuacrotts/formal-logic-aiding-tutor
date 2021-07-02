package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.view.viewdata.settings.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutLabel extends Label {

    public PropositionalTruthTreeTimeoutLabel () {
        super.textProperty().bind(SettingsData.getPropositionalTruthTree().textProperty());
    }

}