package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.colorpane.secondarycolorpane;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SecondaryColorPane extends HBox {
    private SecondaryColorPicker secondaryColorPicker = new SecondaryColorPicker();
    private Region emptyRegion = new Region();

    public SecondaryColorPane () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(new Label("Secondary Color:"), this.emptyRegion, this.secondaryColorPicker);
    }

}