package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.view.data.json.KeyedText;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutLabel extends Label {

    public TruthTableGeneratorTimeoutLabel () {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonAdvancePane.class), KeyedText.toKey2(JsonAdvancePane.Keys.TRUTH_TABLE_GENERATOR)).textProperty());
    }

}