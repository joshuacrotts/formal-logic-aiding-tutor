package com.flat.models.algorithms.bus.events.solver;

import com.flat.algorithms.models.NDWffTree;
import com.flat.tools.buses.eventbus.components.Event;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdateNaturalDeduction extends Event {
    private ArrayList <NDWffTree> ndWffTree;

    public UpdateNaturalDeduction (ArrayList <NDWffTree> _ndWffTree) {
        super(Event.Type.UPDATE_NATURAL_DEDUCTION);
        this.ndWffTree = _ndWffTree;
    }

    // Getters for object's attributes.
    public ArrayList<NDWffTree> getNdWffTree() {
        return ndWffTree;
    }

    // Setters for object's attributes.
    public void setNdWffTree(ArrayList<NDWffTree> ndWffTree) {
        this.ndWffTree = ndWffTree;
    }

}