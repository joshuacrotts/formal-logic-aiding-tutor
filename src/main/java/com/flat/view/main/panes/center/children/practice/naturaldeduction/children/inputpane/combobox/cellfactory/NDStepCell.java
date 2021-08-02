package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.combobox.cellfactory;

import com.flat.algorithms.models.NDStep;
import com.flat.view.data.fx.pane.PaneData;
import javafx.scene.control.ListCell;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NDStepCell extends ListCell <NDStep> {

    public NDStepCell() {
    }

    @Override
    protected void updateItem(NDStep _ndStep, boolean _empty) {
        super.updateItem(_ndStep, _empty);
        if (!(_ndStep == null) && !(_empty)) {
            super.setText(_ndStep.getTextStep());
            super.getListView().backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
        }
    }

}