package com.flat.view.main.panes.bottom.children.formulainput.children.textfield;

import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.interpreter.FormulaInputTextFieldListener;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputTextField extends TextField {
    private FormulaInputTextFieldListener formulaInputTextFieldListener;

    public FormulaInputTextField () {
        this.formulaInputTextFieldListener = new FormulaInputTextFieldListener(this);
    }

}