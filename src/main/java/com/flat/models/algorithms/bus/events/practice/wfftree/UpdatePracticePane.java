package com.flat.models.algorithms.bus.events.practice.wfftree;

import com.flat.algorithms.models.TruthTree;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdatePracticePane extends Event {
    private AlgorithmType algorithmType;
    private WffTree wffTree = null;
    private Boolean algorithmResult = null;
    private ArrayList <WffTree> wffTrees = null;
    private TruthTree truthTree = null;
    private UpdatePracticePane () {
        super(Event.Type.UPDATE_PRACTICE_PANE);
    }

    public UpdatePracticePane (AlgorithmType _algorithmType, ArrayList <WffTree> _wffTrees) {
        this();
        this.algorithmType = _algorithmType;
        this.wffTrees = _wffTrees;
    }

    public UpdatePracticePane (AlgorithmType _algorithmType, TruthTree _truthTree) {
        this();
        this.algorithmType = _algorithmType;
        this.truthTree = _truthTree;
    }

    public UpdatePracticePane (AlgorithmType _algorithmType, WffTree _wffTree) {
        this();
        this.algorithmType = _algorithmType;
        this.wffTree = _wffTree;
    }

    public UpdatePracticePane (AlgorithmType _algorithmType, WffTree _wffTree, boolean _algorithmResult) {
        this();
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

    public ArrayList<WffTree> getWffTrees() {
        return wffTrees;
    }

    public TruthTree getTruthTree() {
        return truthTree;
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

    public void setWffTrees(ArrayList<WffTree> wffTrees) {
        this.wffTrees = wffTrees;
    }

    public void setTruthTree(TruthTree truthTree) {
        this.truthTree = truthTree;
    }

}