package com.flat.input.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UnsolvedFormula extends Event {

    public UnsolvedFormula() {
        super(Type.UNSOLVED_FORMULA);
    }

}