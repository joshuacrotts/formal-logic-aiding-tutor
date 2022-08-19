package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.truthtablegenerator;

import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.truthtablegenerator.children.TruthTableGeneratorTimeoutLabel;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.truthtablegenerator.children.TruthTableGeneratorTimeoutTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableGeneratorTimeoutPane extends HBox {
    private TruthTableGeneratorTimeoutLabel label = new TruthTableGeneratorTimeoutLabel();
    private Region emptyRegion = new Region();
    private TruthTableGeneratorTimeoutTextField textField = new TruthTableGeneratorTimeoutTextField();

    public TruthTableGeneratorTimeoutPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.label, this.emptyRegion, this.textField);
    }

}