package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PredicateNDVTimeoutPane extends HBox {
    private PredicateNDVTimeoutLabel label = new PredicateNDVTimeoutLabel();
    private Region emptyRegion = new Region();
    private PredicateNDVTimeoutTextField textField = new PredicateNDVTimeoutTextField();

    public PredicateNDVTimeoutPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.label, this.emptyRegion, this.textField);
    }

}