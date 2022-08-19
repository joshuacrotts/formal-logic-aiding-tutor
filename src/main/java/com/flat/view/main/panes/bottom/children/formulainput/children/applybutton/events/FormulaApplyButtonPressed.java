package com.flat.view.main.panes.bottom.children.formulainput.children.applybutton.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaApplyButtonPressed extends Event {

    public FormulaApplyButtonPressed () {
        super(Type.FORMULA_APPLY_BUTTON_PRESSED);
    }

}