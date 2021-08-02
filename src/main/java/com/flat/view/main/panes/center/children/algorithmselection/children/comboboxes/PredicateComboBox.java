package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell.AlgorithmListCell;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateComboBox extends ComboBox {

    public PredicateComboBox () {
        super.setItems(Controller.FX_DATA.getAvailableAlgorithms().getPredicateAlgorithms());
        super.setButtonCell(new AlgorithmListCell());
        super.setCellFactory(param -> new AlgorithmListCell());
        super.setPromptText("Predicate");
        super.setMinWidth(250);
        super.setMaxWidth(500);
        super.setVisibleRowCount(5);
    }

}