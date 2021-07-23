package com.flat.view.main.panes.left.children.logicsymbolspane.children.labels;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.propositional.PropositionalSymbols;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalLabel extends Label {

    public PropositionalLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(PropositionalSymbols.class, PropositionalSymbols.Keys.LABEL).textProperty());
    }

}