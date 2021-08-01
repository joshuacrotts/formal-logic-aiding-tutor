package com.flat.models.algorithms.bus.events.practice.wfftree;

import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class EventMainOperatorDetectorPractice extends Event {
    private WffTree wffTree;

    public EventMainOperatorDetectorPractice (WffTree _wffTree) {
        super(Event.Type.EVENT_MAIN_OPERATOR_DETECTOR_PRACTICE);
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