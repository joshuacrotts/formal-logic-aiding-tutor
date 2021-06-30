package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.view.viewdata.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutTextField extends NumericTextField {

    public PropositionalTruthTreeTimeoutTextField() {
        super.textProperty().bindBidirectional(SettingsData.getPropositionalTruthTreeTimeout().textProperty());
    }

}