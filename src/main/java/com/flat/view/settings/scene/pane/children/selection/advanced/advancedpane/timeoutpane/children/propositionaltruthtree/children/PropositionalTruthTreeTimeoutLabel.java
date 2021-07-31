package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.propositionaltruthtree.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advanced.content.AdvancedPane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutLabel extends Label {

    public PropositionalTruthTreeTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.PROPOSITIONAL_TRUTH_TREE).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.PROPOSITIONAL_TRUTH_TREE).fontProperty());
    }

}