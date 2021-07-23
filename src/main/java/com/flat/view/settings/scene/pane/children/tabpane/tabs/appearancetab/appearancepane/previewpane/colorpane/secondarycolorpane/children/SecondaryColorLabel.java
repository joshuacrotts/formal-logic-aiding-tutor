package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.secondarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.appearance.content.ColorPane;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SecondaryColorLabel extends Label {

    public SecondaryColorLabel() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.SECONDARY_COLOR).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.SECONDARY_COLOR).fontProperty());
    }

}