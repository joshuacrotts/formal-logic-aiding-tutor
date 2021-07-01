package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.children;

import com.flat.view.viewdata.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PropositionalNDVTimeoutLabel extends Label {

    public PropositionalNDVTimeoutLabel () {
        super.textProperty().bind(SettingsData.getPropositionalNDV().textProperty());
    }

}