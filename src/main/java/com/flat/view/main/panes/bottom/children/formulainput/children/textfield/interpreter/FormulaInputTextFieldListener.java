package com.flat.view.main.panes.bottom.children.formulainput.children.textfield.interpreter;

import com.flat.controller.Controller;
import com.flat.tools.eventbus.base.Event;
import static com.flat.tools.eventbus.base.Event.Type.FORMULA_SOLVE_BUTTON_PRESSED;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.FormulaInputTextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInputTextFieldListener implements Listener {
    private FormulaInputTextField formulaInputTextField;

    public FormulaInputTextFieldListener (FormulaInputTextField _formulaInputTextField) {
        this.formulaInputTextField = _formulaInputTextField;
        Controller.getEVENT_BUS().addListener(this);
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case FORMULA_SOLVE_BUTTON_PRESSED:
                if (this.formulaInputTextField.getText() != "")
                    Controller.inputFormula(this.formulaInputTextField.getText());
                break;
        }
    }

}
