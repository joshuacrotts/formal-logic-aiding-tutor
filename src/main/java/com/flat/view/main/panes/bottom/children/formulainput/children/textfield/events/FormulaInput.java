package com.flat.view.main.panes.bottom.children.formulainput.children.textfield.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaInput extends Event{
    private String formula;

    public FormulaInput(String _formula) {
        super(Event.Type.FORMULA_INPUT);
    }

    // Getters for object's attributes.
    public String getFormula() {
        return formula;
    }

    // Setters for object's attributes.
    public void setFormula(String formula) {
        this.formula = formula;
    }

}