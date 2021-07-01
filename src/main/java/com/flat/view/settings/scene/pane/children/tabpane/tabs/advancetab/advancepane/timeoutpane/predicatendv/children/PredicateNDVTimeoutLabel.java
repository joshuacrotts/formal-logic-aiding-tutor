package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.children;

import com.flat.view.viewdata.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateNDVTimeoutLabel extends Label {

    public PredicateNDVTimeoutLabel () {
        super.textProperty().bind(SettingsData.getPredicateNDV().textProperty());
    }

}