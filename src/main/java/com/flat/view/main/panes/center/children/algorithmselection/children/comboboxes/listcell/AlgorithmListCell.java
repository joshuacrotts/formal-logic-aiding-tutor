package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell;

import com.flat.models.json.algorithm.JsonAlgorithm;
import javafx.scene.control.ListCell;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmListCell extends ListCell<JsonAlgorithm> {

    public AlgorithmListCell () {
    }

    @Override
    protected void updateItem(JsonAlgorithm _algorithm, boolean _empty) {
        super.updateItem(_algorithm, _empty);
        if (_algorithm != null && !_empty)
            super.setText(_algorithm.getJsonString().getString());
    }

}