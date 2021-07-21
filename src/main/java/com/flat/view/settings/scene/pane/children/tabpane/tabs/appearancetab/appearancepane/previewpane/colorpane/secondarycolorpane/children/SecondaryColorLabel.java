package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.secondarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.view.data.json.MappedText;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SecondaryColorLabel extends Label {

    public SecondaryColorLabel() {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.SECONDARY_COLOR)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonColorPane.class), MappedText.toKey2(JsonColorPane.Keys.SECONDARY_COLOR)).fontProperty());

    }

}