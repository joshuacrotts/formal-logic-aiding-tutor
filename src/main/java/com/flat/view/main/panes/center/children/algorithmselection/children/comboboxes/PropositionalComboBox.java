package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell.AlgorithmListCell;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalComboBox extends ComboBox {

    public PropositionalComboBox () {
        super.setItems(Controller.FX_DATA.getAvailableAlgorithms().getPropositionalAlgorithms());
        super.setButtonCell(new AlgorithmListCell());
        super.setCellFactory(param -> new AlgorithmListCell());
        super.setPromptText("Propositional");
        super.setMinWidth(250);
        super.setMaxWidth(500);
    }

}