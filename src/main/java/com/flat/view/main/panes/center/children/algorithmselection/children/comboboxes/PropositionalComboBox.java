package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes;

import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell.AlgorithmListCell;
import com.flat.view.data.algorithms.AvailableAlgorithms;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalComboBox extends ComboBox {

    public PropositionalComboBox () {
        super.setItems(AvailableAlgorithms.getPropositionalAlgorithms());
        super.setButtonCell(new AlgorithmListCell());
        super.setCellFactory(param -> new AlgorithmListCell());
        super.setPromptText("Propositional");
    }

}