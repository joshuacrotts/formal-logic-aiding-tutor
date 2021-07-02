package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.children;

import com.flat.view.viewdata.settings.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PropositionalNDVTimeoutTextField extends NumericTextField {

    public PropositionalNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(SettingsData.getPropositionalNDVTimeout().textProperty());
    }

}