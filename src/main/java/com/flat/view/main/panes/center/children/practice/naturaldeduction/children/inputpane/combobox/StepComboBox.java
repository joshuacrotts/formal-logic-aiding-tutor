package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.combobox;

import com.flat.algorithms.models.NDStep;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.combobox.cellfactory.NDButtonCell;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.combobox.cellfactory.NDStepCell;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class StepComboBox extends ComboBox {

    public StepComboBox () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setPromptText("Step");
        super.setItems(FXCollections.observableArrayList(NDStep.values()));
        super.setButtonCell(new NDButtonCell());
        super.setCellFactory(param -> new NDStepCell());
        super.setVisibleRowCount(5);
    }

}