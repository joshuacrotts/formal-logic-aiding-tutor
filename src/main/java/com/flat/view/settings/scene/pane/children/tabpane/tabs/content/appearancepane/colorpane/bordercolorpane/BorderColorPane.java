package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.colorpane.bordercolorpane;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BorderColorPane extends HBox {
    private BorderColorPicker borderColorPicker = new BorderColorPicker();
    private Region emptyRegion = new Region();

    public BorderColorPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(new Label("Border color:"), this.emptyRegion, this.borderColorPicker);

    }

}