package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.secondarycolorpane.children;

import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SecondaryColorPicker extends ColorPicker {

    public SecondaryColorPicker() {
        super.setValue(AppearancePreviewData.getSecondaryColor().getColor());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            AppearancePreviewData.getSecondaryColor().setColor(new Color(super.getValue().getRed(), super.getValue().getGreen(), super.getValue().getBlue(), super.getValue().getOpacity()));
        });
    }

}