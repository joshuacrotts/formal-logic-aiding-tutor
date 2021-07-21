package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.view.data.json.MappedText;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutLabel extends Label {

    public PropositionalTruthTreeTimeoutLabel () {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonAdvancePane.class), MappedText.toKey2(JsonAdvancePane.Keys.PROPOSITIONAL_TRUTH_TREE)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonAdvancePane.class), MappedText.toKey2(JsonAdvancePane.Keys.PROPOSITIONAL_TRUTH_TREE)).fontProperty());
    }

}