package com.flat.models.algorithms.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaGenerated extends Event {
    private String formula = null;

    public FormulaGenerated (String _formula) {
        super(Event.Type.FORMULA_GENERATED);
        this.formula = _formula;
    }

    // Getters for object's attributes.
    public String getFormula () {
        return formula;
    }

    // Setters for object's attributes.
    public void setFormula (String formula) {
        this.formula = formula;
    }

}