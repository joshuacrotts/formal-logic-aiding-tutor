package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.children;

import com.flat.controller.Controller;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.view.data.json.KeyedText;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalNDVTimeoutLabel extends Label {

    public PropositionalNDVTimeoutLabel () {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonAdvancePane.class), KeyedText.toKey2(JsonAdvancePane.Keys.PROPOSITIONAL_NDV)).textProperty());
    }

}