package com.flat.view.main.panes.bottom.children.formulainput.children.textfield;

import com.flat.controller.Controller;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.listener.FormulaInputTextFieldListener;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputTextField extends TextField {
    private int focusedCaretPosition = 0;

    public FormulaInputTextField () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new FormulaInputTextFieldListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.caretPositionProperty().addListener((obs, oldVal, newVal) -> {
            if (super.isFocused() == false)
                this.focusedCaretPosition = oldVal.intValue();
            else
                this.focusedCaretPosition = newVal.intValue();
        });
    }

    // Getters for object's attributes.
    public int getFocusedCaretPosition() {
        return focusedCaretPosition;
    }

    // Setters for object's attributes.
    public void setFocusedCaretPosition(int focusedCaretPosition) {
        this.focusedCaretPosition = focusedCaretPosition;
    }

}