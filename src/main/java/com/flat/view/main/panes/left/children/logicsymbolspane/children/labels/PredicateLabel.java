package com.flat.view.main.panes.left.children.logicsymbolspane.children.labels;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.predicate.PredicateSymbols;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateLabel extends Label {

    public PredicateLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(PredicateSymbols.class, PredicateSymbols.Keys.LABEL).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(PredicateSymbols.class, PredicateSymbols.Keys.LABEL).fontProperty());
    }

}