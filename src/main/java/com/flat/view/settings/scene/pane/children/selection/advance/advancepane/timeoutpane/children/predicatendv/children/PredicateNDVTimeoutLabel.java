package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.predicatendv.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.content.AdvancePane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateNDVTimeoutLabel extends Label {

    public PredicateNDVTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PREDICATE_NDV).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PREDICATE_NDV).fontProperty());
    }

}