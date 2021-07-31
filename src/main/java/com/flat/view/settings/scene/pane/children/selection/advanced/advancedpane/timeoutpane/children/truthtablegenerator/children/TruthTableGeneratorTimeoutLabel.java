package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.truthtablegenerator.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advanced.content.AdvancedPane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutLabel extends Label {

    public TruthTableGeneratorTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.TRUTH_TABLE_GENERATOR).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancedPane.class, AdvancedPane.Keys.TRUTH_TABLE_GENERATOR).fontProperty());
    }

}