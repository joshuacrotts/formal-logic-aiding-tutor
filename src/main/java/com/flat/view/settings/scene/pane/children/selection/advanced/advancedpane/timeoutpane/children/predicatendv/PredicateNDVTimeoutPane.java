package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatendv;

import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatendv.children.PredicateNDVTimeoutLabel;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.predicatendv.children.PredicateNDVTimeoutTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
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