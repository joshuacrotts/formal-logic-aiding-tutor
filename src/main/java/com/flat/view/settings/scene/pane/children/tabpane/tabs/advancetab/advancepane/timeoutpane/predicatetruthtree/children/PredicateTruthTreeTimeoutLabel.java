package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutLabel extends Label {

    public PredicateTruthTreeTimeoutLabel () {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(JsonAdvancePane.class, JsonAdvancePane.Keys.PREDICATE_TRUTH_TRUTH).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(JsonAdvancePane.class, JsonAdvancePane.Keys.PREDICATE_TRUTH_TRUTH).fontProperty());
    }

}