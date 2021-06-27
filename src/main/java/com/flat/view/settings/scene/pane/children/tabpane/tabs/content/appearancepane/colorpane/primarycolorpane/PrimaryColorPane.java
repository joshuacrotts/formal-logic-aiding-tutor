package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.colorpane.primarycolorpane;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PrimaryColorPane extends HBox {
    private final PrimaryColorPicker primaryColorPicker = new PrimaryColorPicker();
    private final Region emptyRegion = new Region();

    public PrimaryColorPane() {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(new Label("Primary Color:"), this.emptyRegion, this.primaryColorPicker);
    }

}