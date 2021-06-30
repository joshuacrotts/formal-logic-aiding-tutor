package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalTruthTreeTimeoutPane extends HBox {
    private PropositionalTruthTreeTimeoutLabel label = new PropositionalTruthTreeTimeoutLabel();
    private Region emptyRegion = new Region();
    private PropositionalTruthTreeTimeoutTextField textField = new PropositionalTruthTreeTimeoutTextField();

    public PropositionalTruthTreeTimeoutPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.label, this.emptyRegion, this.textField);
    }

}
