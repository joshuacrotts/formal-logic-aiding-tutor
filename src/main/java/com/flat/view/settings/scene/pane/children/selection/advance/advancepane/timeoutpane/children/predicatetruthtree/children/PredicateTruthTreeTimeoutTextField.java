package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.predicatetruthtree.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.base.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutTextField extends NumericTextField {

    public PredicateTruthTreeTimeoutTextField () {
        super.textProperty().bindBidirectional(TimeoutManager.getPREDICATE_TRUTH_TREE().textProperty());
    }

}