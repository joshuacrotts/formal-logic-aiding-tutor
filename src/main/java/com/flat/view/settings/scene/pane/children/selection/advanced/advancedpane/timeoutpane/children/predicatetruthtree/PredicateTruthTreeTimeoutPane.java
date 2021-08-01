package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatetruthtree;

import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatetruthtree.children.PredicateTruthTreeTimeoutLabel;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatetruthtree.children.PredicateTruthTreeTimeoutTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateTruthTreeTimeoutPane extends HBox {
    private PredicateTruthTreeTimeoutLabel label = new PredicateTruthTreeTimeoutLabel();
    private Region emptyRegion = new Region();
    private PredicateTruthTreeTimeoutTextField textField = new PredicateTruthTreeTimeoutTextField();

    public PredicateTruthTreeTimeoutPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.label, this.emptyRegion, this.textField);
    }

}