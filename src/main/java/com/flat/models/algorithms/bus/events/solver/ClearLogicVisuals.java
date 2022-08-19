package com.flat.models.algorithms.bus.events.solver;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ClearLogicVisuals extends Event {

    public ClearLogicVisuals () {
        super(Type.CLEAR_LOGIC_VISUALS);
    }

}