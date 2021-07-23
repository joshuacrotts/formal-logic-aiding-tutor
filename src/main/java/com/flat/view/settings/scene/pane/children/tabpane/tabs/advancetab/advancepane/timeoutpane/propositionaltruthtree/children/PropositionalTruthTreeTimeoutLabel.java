package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.content.AdvancePane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutLabel extends Label {

    public PropositionalTruthTreeTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PROPOSITIONAL_TRUTH_TREE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PROPOSITIONAL_TRUTH_TREE).fontProperty());
    }

}