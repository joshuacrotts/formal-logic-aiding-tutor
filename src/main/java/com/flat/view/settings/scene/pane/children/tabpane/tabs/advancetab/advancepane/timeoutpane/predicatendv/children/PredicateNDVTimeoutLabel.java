package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateNDVTimeoutLabel extends Label {

    public PredicateNDVTimeoutLabel () {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(JsonAdvancePane.class, JsonAdvancePane.Keys.PREDICATE_NDV).textProperty());
        super.fontProperty().bind(Controller.getKEYED_TEXT().getValue(JsonAdvancePane.class, JsonAdvancePane.Keys.PREDICATE_NDV).fontProperty());
    }

}