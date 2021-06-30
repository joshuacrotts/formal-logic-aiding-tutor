package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PropositionalNDVTimeoutPane extends HBox {
    private PropositionalNDVTimeoutLabel label = new PropositionalNDVTimeoutLabel();
    private Region emptyRegion = new Region();
    private PropositionalNDVTimeoutTextField textField = new PropositionalNDVTimeoutTextField();

    public PropositionalNDVTimeoutPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.label, this.emptyRegion, this.textField);
    }

}