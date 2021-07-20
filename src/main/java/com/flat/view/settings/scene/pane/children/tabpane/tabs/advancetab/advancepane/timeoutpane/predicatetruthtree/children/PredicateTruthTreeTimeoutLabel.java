package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children;

import com.flat.view.data.settings.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutLabel extends Label {

    public PredicateTruthTreeTimeoutLabel () {
        super.textProperty().bind(SettingsData.getPredicateTruthTree().textProperty());
    }

}