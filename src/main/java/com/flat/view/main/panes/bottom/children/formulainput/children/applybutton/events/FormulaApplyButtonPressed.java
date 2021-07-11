package com.flat.view.main.panes.bottom.children.formulainput.children.applybutton.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FormulaApplyButtonPressed extends Event {

    public FormulaApplyButtonPressed () {
        super(Event.Type.FORMULA_APPLY_BUTTON_PRESSED);
    }

}