package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.appearance.content.ColorPane;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorLabel extends Label {

    public PrimaryColorLabel() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.PRIMARY_COLOR).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(ColorPane.class, ColorPane.Keys.PRIMARY_COLOR).fontProperty());
    }

}