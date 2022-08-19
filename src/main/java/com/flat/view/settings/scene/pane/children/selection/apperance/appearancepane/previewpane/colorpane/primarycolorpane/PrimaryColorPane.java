package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane.children.PrimaryColorLabel;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane.children.PrimaryColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorPane extends HBox {
    private final PrimaryColorLabel primaryColorLabel = new PrimaryColorLabel();
    private final Region emptyRegion = new Region();
    public static final PrimaryColorPicker primaryColorPicker = new PrimaryColorPicker();

    public PrimaryColorPane() {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
        super.setSpacing(10);
        super.getChildren().addAll(this.primaryColorLabel, this.emptyRegion, this.primaryColorPicker);
    }

}