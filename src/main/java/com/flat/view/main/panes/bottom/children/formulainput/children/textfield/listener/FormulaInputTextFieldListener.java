package com.flat.view.main.panes.bottom.children.formulainput.children.textfield.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.bus.events.FormulaGenerated;
import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.FORMULA_SOLVE_BUTTON_PRESSED;
import com.flat.view.main.panes.bottom.children.formulainput.children.textfield.FormulaInputTextField;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.events.LogicButtonPressed;

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
            case LOGIC_BUTTON_PRESSED:
                this.addTextAtCaret(((LogicButtonPressed)_event).getText());
                this.refocusTextField();
                break;
            case FORMULA_GENERATED:
                this.formulaInputTextField.setText(((FormulaGenerated)_event).getFormula());
                Controller.inputFormula(((FormulaGenerated)_event).getFormula());
                break;
        }
    }

    private void addTextAtCaret (String _text) {
        String preCaret = this.formulaInputTextField.getText().substring(0, this.formulaInputTextField.getFocusedCaretPosition());
        String postCaret = this.formulaInputTextField.getText().substring(this.formulaInputTextField.getFocusedCaretPosition(), this.formulaInputTextField.getText().length());
        this.formulaInputTextField.setText(preCaret + _text + postCaret);
        this.formulaInputTextField.setFocusedCaretPosition(this.formulaInputTextField.getFocusedCaretPosition() + 1);
    }

    private void refocusTextField () {
        this.formulaInputTextField.requestFocus();
                this.formulaInputTextField.deselect();
                this.formulaInputTextField.positionCaret(this.formulaInputTextField.getFocusedCaretPosition());
    }

}