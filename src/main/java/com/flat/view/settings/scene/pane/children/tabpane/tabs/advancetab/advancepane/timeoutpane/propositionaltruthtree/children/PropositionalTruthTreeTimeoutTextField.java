package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutTextField extends TextField {

    public PropositionalTruthTreeTimeoutTextField() {
        super.textProperty().bindBidirectional(FxSettingsData.getPropositionalTruthTreeTimeout().textProperty());
    }

}