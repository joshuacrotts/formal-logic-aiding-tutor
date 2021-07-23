package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.bordercolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.appearance.content.ColorPane;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BorderColorLabel extends Label {

    public BorderColorLabel() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.BORDER_COLOR).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.BORDER_COLOR).fontProperty());

    }

}