package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes;

import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell.AlgorithmListCell;
import com.flat.view.data.fx.algorithms.AvailableAlgorithms;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class GeneralComboBox extends ComboBox {

    public GeneralComboBox () {
        super.setItems(AvailableAlgorithms.getGeneralAlgorithms());
        super.setButtonCell(new AlgorithmListCell());
        super.setCellFactory(param -> new AlgorithmListCell());
        super.setPromptText("General");
    }

}