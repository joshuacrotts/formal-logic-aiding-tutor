package com.flat.input.events;

import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SolvedFormula extends Event {
    private WffTree wffTree;

    public SolvedFormula (WffTree _wffTree) {
        super(Event.Type.SOLVED_FORMULA);
        this.wffTree = _wffTree;
    }

    // Getters for object's attributes.
    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

}