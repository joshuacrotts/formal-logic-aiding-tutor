package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.primarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.view.data.json.MappedText;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorLabel extends Label {

    public PrimaryColorLabel() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.PRIMARY_COLOR)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.PRIMARY_COLOR)).fontProperty());
    }

}