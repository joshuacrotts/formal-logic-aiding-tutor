package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutTextField extends TextField {

    public TruthTableGeneratorTimeoutTextField () {
        super.textProperty().bindBidirectional(FxSettingsData.getTruthTableTimeout().textProperty());
    }

}