package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children.PredicateTruthTreeTimeoutLabel;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.children.PredicateTruthTreeTimeoutTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
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