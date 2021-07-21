package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutTextField extends NumericTextField {

    public PropositionalTruthTreeTimeoutTextField() {
        super.textProperty().bindBidirectional(TimeoutManager.getPROPOSITIONAL_TRUTH_TREE().textProperty());
    }

}