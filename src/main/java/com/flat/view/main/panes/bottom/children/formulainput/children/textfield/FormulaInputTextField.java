package com.flat.view.main.panes.bottom.children.formulainput.children.textfield;

import com.flat.controller.Controller;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.interpreter.FormulaInputTextFieldListener;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputTextField extends TextField {

    public FormulaInputTextField () {
        Controller.EVENT_BUS.addListener(new FormulaInputTextFieldListener(this));
    }

}