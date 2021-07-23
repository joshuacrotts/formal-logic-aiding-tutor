package com.flat.models.algorithms.bus.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ClearLogicVisuals extends Event {

    public ClearLogicVisuals () {
        super(Event.Type.CLEAR_LOGIC_VISUALS);
    }

}