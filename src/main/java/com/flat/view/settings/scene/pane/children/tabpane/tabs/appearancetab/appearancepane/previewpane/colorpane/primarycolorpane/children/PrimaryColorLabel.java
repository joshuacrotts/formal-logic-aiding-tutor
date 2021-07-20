package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.primarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.view.data.json.KeyedText;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorLabel extends Label {

    public PrimaryColorLabel() {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonColorPane.class), KeyedText.toKey2(JsonColorPane.Keys.PRIMARY_COLOR)).textProperty());
        super.fontProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonColorPane.class), KeyedText.toKey2(JsonColorPane.Keys.PRIMARY_COLOR)).fontProperty());
    }

}