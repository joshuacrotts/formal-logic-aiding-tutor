package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.bordercolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.view.data.json.MappedText;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BorderColorLabel extends Label {

    public BorderColorLabel() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.BORDER_COLOR)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.BORDER_COLOR)).fontProperty());

    }

}