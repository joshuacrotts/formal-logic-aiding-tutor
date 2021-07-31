package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.propositionalndv.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.base.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalNDVTimeoutTextField extends NumericTextField {

    public PropositionalNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(TimeoutManager.getPROPOSITIONAL_NDV().textProperty());
    }

}