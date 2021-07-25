package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.propositionalndv.children;

import com.flat.controller.Controller;
import com.flat.models.data.settings.tabs.advance.content.AdvancePane;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalNDVTimeoutLabel extends Label {

    public PropositionalNDVTimeoutLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PROPOSITIONAL_NDV).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(AdvancePane.class, AdvancePane.Keys.PROPOSITIONAL_NDV).fontProperty());

    }

}