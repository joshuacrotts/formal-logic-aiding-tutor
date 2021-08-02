package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane;

import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.combobox.StepComboBox;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.textfields.LineTextField;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.textfields.WffTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionInputPane extends HBox {
    private WffTextField wffInput = new WffTextField();
    private StepComboBox stepInput = new StepComboBox();
    private LineTextField lineInput = new LineTextField();

    public NaturalDeductionInputPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.wffInput, this.stepInput, this.lineInput);
        super.setSpacing(5);
        super.setAlignment(Pos.CENTER);
    }

    public void clear () {
        this.wffInput.clear();
        this.stepInput.getSelectionModel().clearSelection();
        this.lineInput.clear();
    }

    // Getters for object's attributes.
    public WffTextField getWffInput() {
        return wffInput;
    }

    public StepComboBox getStepInput() {
        return stepInput;
    }

    public LineTextField getLineInput() {
        return lineInput;
    }

    // Setters for object's attributes.
    public void setWffInput(WffTextField wffInput) {
        this.wffInput = wffInput;
    }

    public void setStepInput(StepComboBox stepInput) {
        this.stepInput = stepInput;
    }

    public void setLineInput(LineTextField lineInput) {
        this.lineInput = lineInput;
    }

}