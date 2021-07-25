package com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.listcell;

import com.flat.models.data.algorithms.base.Algorithm;
import javafx.scene.control.ListCell;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmListCell extends ListCell <Algorithm> {

    public AlgorithmListCell () {
    }

    @Override
    protected void updateItem(Algorithm _algorithm, boolean _empty) {
        super.updateItem(_algorithm, _empty);
        if (_algorithm != null && !_empty)
            super.setText(_algorithm.getLabel().getText());
    }

}