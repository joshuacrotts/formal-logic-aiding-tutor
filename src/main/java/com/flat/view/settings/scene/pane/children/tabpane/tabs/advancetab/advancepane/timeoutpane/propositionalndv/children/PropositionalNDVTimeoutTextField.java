package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalNDVTimeoutTextField extends NumericTextField {

    public PropositionalNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(TimeoutManager.getPROPOSITIONAL_NDV().textProperty());
    }

}