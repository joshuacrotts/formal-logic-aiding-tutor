package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.naturaldeduction.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionButtonPressed extends Event {

    public NaturalDeductionButtonPressed () {
        super(Type.NATURAL_DEDUCTION_BUTTON_PRESSED);
    }

}