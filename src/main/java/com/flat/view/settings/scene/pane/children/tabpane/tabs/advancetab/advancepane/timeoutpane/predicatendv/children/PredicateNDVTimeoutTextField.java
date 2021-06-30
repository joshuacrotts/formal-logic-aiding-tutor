package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.children;

import com.flat.view.viewdata.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateNDVTimeoutTextField extends NumericTextField {

    public PredicateNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(SettingsData.getPredicateNDVTimeout().textProperty());
    }

}