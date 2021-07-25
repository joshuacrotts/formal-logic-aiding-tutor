package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.propositionaltruthtree.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.base.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutTextField extends NumericTextField {

    public PropositionalTruthTreeTimeoutTextField() {
        super.textProperty().bindBidirectional(TimeoutManager.getPROPOSITIONAL_TRUTH_TREE().textProperty());
    }

}