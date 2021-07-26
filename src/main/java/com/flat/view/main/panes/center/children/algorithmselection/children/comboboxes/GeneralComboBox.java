package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell.AlgorithmListCell;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class GeneralComboBox extends ComboBox {

    public GeneralComboBox () {
        super.setItems(Controller.FX_DATA.getAvailableAlgorithms().getGeneralAlgorithms());
        super.setButtonCell(new AlgorithmListCell());
        super.setCellFactory(param -> new AlgorithmListCell());
        super.setPromptText("General");
        super.setMinWidth(100);
    }

}