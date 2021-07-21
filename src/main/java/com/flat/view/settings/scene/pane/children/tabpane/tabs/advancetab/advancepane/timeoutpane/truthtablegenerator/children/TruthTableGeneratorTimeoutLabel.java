package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.view.data.json.MappedText;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutLabel extends Label {

    public TruthTableGeneratorTimeoutLabel () {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonAdvancePane.class), MappedText.toKey2(JsonAdvancePane.Keys.TRUTH_TABLE_GENERATOR)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonAdvancePane.class), MappedText.toKey2(JsonAdvancePane.Keys.TRUTH_TABLE_GENERATOR)).fontProperty());
    }

}