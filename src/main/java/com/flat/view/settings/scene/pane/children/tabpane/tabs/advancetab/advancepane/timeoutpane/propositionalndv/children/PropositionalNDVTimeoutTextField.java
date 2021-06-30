package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.children;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PropositionalNDVTimeoutTextField extends TextField {

    public PropositionalNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(FxSettingsData.getPropositionalNDVTimeout().textProperty());
    }

}