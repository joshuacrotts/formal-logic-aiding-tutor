package com.flat.models.algorithms.bus.events.solver;

import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdateParseTree extends Event {
    private WffTree wffTree;

    public UpdateParseTree (WffTree _wffTree) {
        super(Type.UPDATE_PARSE_TREE);
        this.wffTree = _wffTree;
    }

    // Getters for object's attributes.
    public WffTree getWffTree () {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setWffTree (WffTree wffTree) {
        this.wffTree = wffTree;
    }

}