package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.models.TimeoutManager;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutTextField extends NumericTextField {

    public TruthTableGeneratorTimeoutTextField () {
        super.textProperty().bindBidirectional(TimeoutManager.getTRUTH_TABLE().textProperty());
    }

}