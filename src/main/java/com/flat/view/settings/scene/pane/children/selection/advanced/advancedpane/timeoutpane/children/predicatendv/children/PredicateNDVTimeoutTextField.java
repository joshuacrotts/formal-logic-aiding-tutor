package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatendv.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.base.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateNDVTimeoutTextField extends NumericTextField {

    public PredicateNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(TimeoutManager.getPREDICATE_NDV().textProperty());
        super.fontProperty().bindBidirectional(TimeoutManager.getPREDICATE_NDV().fontProperty());
    }

}