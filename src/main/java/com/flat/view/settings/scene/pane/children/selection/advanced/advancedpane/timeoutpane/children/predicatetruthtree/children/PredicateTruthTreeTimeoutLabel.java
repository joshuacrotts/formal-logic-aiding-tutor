package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatetruthtree.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advanced.content.AdvancedPane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutLabel extends Label {

    public PredicateTruthTreeTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.PREDICATE_TRUTH_TRUTH).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.PREDICATE_TRUTH_TRUTH).fontProperty());
    }

}