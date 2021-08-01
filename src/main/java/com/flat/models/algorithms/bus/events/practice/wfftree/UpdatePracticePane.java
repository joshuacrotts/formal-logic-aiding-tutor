package com.flat.models.algorithms.bus.events.practice.wfftree;

import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdatePracticePane extends Event {
    private AlgorithmType algorithmType;
    private WffTree wffTree = null;
    private Boolean algorithmResult = null;

    public UpdatePracticePane (AlgorithmType _algorithmType, WffTree _wffTree) {
        super(Event.Type.UPDATE_PRACTICE_PANE);
        this.algorithmType = _algorithmType;
        this.wffTree = _wffTree;
    }

    public UpdatePracticePane (AlgorithmType _algorithmType, WffTree _wffTree, boolean _algorithmResult) {
        super(Event.Type.UPDATE_PRACTICE_PANE);
        this.algorithmType = _algorithmType;
        this.wffTree = _wffTree;
        this.algorithmResult = _algorithmResult;
    }

    // Getters for object's attributes.
    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    public Boolean getAlgorithmResult() {
        return algorithmResult;
    }

    // Setters for object's attributes.
    public void setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

    public void setAlgorithmResult(Boolean algorithmResult) {
        this.algorithmResult = algorithmResult;
    }

}