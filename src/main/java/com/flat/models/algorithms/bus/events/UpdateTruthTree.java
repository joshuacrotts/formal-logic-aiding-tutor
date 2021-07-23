package com.flat.models.algorithms.bus.events;

import com.flat.algorithms.models.TruthTree;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdateTruthTree extends Event {
    private TruthTree truthTree;

    public UpdateTruthTree (TruthTree _truthTree) {
        super(Event.Type.UPDATE_TRUTH_TREE);
        this.truthTree = _truthTree;
    }

    // Getters for object's attributes.
    public TruthTree getTruthTree () {
        return truthTree;
    }

    // Setters for object's attributes.
    public void setTruthTree (TruthTree truthTree) {
        this.truthTree = truthTree;
    }

}