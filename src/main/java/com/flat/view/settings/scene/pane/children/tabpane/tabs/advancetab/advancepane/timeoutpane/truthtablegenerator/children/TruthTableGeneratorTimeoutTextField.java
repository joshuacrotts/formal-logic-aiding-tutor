package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.view.viewdata.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.NumericTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutTextField extends NumericTextField {

    public TruthTableGeneratorTimeoutTextField () {
        super.textProperty().bindBidirectional(SettingsData.getTruthTableTimeout().textProperty());
    }

}