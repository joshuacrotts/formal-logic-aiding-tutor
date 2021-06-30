package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.children;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateNDVTimeoutTextField extends TextField {

    public PredicateNDVTimeoutTextField () {
        super.textProperty().bindBidirectional(FxSettingsData.getPredicateNDVTimeout().textProperty());
    }

}