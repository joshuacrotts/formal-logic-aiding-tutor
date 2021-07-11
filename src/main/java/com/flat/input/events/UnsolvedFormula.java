package com.flat.input.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UnsolvedFormula extends Event {

    public UnsolvedFormula() {
        super(Event.Type.UNSOLVED_FORMULA);
    }

}