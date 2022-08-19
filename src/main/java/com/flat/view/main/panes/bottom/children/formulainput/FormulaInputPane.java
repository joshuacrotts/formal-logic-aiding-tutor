package com.flat.view.main.panes.bottom.children.formulainput;

import com.flat.view.main.panes.bottom.children.formulainput.children.applybutton.FormulaApplyButton;
import com.flat.view.main.panes.bottom.children.formulainput.children.solvebutton.FormulaSolveButton;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.FormulaInputTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputPane extends HBox {
    private FormulaSolveButton solveButton = new FormulaSolveButton();
    private FormulaInputTextField textField = new FormulaInputTextField();
    private FormulaApplyButton applyButton = new FormulaApplyButton();

    public FormulaInputPane () {
        super.getChildren().addAll(this.solveButton, this.textField, this.applyButton);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setTextFieldFx();
    }

    private void setTextFieldFx () {
        HBox.setHgrow(this.textField, Priority.ALWAYS);
    }

}