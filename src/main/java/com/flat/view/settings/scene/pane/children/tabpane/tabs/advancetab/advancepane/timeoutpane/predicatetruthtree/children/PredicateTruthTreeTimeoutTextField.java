package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children;

import com.flat.view.data.settings.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutTextField extends NumericTextField {

    public PredicateTruthTreeTimeoutTextField () {
        super.textProperty().bindBidirectional(SettingsData.getPredicateTruthTreeTimeout().textProperty());
    }

}