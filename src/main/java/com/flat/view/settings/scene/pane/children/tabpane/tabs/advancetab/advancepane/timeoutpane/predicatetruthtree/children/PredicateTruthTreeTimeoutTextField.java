package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children;

import com.flat.view.viewdata.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateTruthTreeTimeoutTextField extends NumericTextField {

    public PredicateTruthTreeTimeoutTextField () {
        super.textProperty().bindBidirectional(SettingsData.getPredicateTruthTreeTimeout().textProperty());
    }

}