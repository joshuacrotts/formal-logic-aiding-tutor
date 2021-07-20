package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.view.data.settings.SettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutLabel extends Label {

    public TruthTableGeneratorTimeoutLabel () {
        super.textProperty().bind(SettingsData.getTruthTableGenerator().textProperty());
    }

}