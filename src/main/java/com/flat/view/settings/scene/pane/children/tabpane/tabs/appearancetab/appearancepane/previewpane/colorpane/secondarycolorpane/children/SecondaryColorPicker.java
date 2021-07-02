package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.secondarycolorpane.children;

import com.flat.view.viewdata.settings.AppearancePreviewData;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SecondaryColorPicker extends ColorPicker {

    public SecondaryColorPicker() {
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            AppearancePreviewData.getSecondaryColor().setColor(new Color(super.getValue().getRed(), super.getValue().getGreen(), super.getValue().getBlue(), super.getValue().getOpacity()));
        });
    }

}