package com.flat.view.main.panes.bottom.children.formulainput.children.textfield.interpreter;

import com.flat.controller.Controller;
import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.FORMULA_SOLVE_BUTTON_PRESSED;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.FormulaInputTextField;
import com.flat.tools.buses.eventbus.components.EventListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputTextFieldListener implements EventListener {
    private FormulaInputTextField formulaInputTextField;

    public FormulaInputTextFieldListener (FormulaInputTextField _formulaInputTextField) {
        this.formulaInputTextField = _formulaInputTextField;
    }

    @Override
    public void catchEvent (Event _event) {
        switch (_event.getType()) {
            case FORMULA_SOLVE_BUTTON_PRESSED:
                if (!this.formulaInputTextField.getText().isEmpty())
                    Controller.inputFormula(this.formulaInputTextField.getText());
                break;
        }
    }

}
