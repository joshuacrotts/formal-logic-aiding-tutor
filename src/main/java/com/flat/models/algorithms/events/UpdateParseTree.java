package com.flat.models.algorithms.events;

import com.flat.models.treenode.WffTree;
import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdateParseTree extends Event {
    private WffTree wffTree;

    public UpdateParseTree (WffTree _wffTree) {
        super(Event.Type.UPDATE_PARSE_TREE);
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