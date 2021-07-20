package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.secondarycolorpane.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.view.data.json.KeyedText;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SecondaryColorLabel extends Label {

    public SecondaryColorLabel() {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonColorPane.class), KeyedText.toKey2(JsonColorPane.Keys.SECONDARY_COLOR)).textProperty());
    }

}