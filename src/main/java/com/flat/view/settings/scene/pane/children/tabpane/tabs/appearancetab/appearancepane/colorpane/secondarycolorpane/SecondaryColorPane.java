package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.secondarycolorpane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SecondaryColorPane extends HBox {
    private final SecondaryColorLabel secondaryColorLabel = new SecondaryColorLabel();
    private final Region emptyRegion = new Region();
    private final SecondaryColorPicker secondaryColorPicker = new SecondaryColorPicker();

    public SecondaryColorPane() {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.secondaryColorLabel, this.emptyRegion, this.secondaryColorPicker);
    }

}