package com.flat.models.algorithms.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ClearLogicVisuals extends Event {

    public ClearLogicVisuals () {
        super(Event.Type.CLEAR_LOGIC_VISUALS);
    }

}