package com.flat.models.algorithms.bus.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdateTruth extends Event {
    private boolean truth;

    public UpdateTruth(boolean _truth) {
        super(Event.Type.UPDATE_TRUTH);
        this.truth = _truth;
    }

    // Getters for object's attributes.
    public boolean isTruth() {
        return truth;
    }

    // Setters for object's attributes.
    public void setTruth(boolean truth) {
        this.truth = truth;
    }

}