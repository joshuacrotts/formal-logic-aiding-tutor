package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.bordercolorpane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BorderColorPane extends HBox {
    private final BorderColorLabel borderColorLabel = new BorderColorLabel();
    private final Region emptyRegion = new Region();
    private final BorderColorPicker borderColorPicker = new BorderColorPicker();

    public BorderColorPane() {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.borderColorLabel, this.emptyRegion, this.borderColorPicker);

    }

}