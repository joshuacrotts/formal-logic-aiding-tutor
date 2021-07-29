package com.flat.models.algorithms.attributes;

import com.flat.algorithms.models.NDWffTree;
import com.flat.algorithms.models.TruthTree;
import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class LogicReturn {
    private Boolean truthValue = null;
    private TruthTree truthTree = null;
    private WffTree wffTree = null;
    private String formula = null;
    private ArrayList <NDWffTree> ndWffTree = null;

    public LogicReturn () {
    }

    public LogicReturn (String _formula) {
        this.formula = _formula;
    }

    public LogicReturn (WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    public LogicReturn (TruthTree _truthTree, WffTree _wffTree) {
        this.truthTree = _truthTree;
        this.wffTree = _wffTree;
    }

    public LogicReturn (ArrayList <NDWffTree> _ndWffTree) {
        this.ndWffTree = _ndWffTree;
    }

    public LogicReturn (Boolean _truthValue, WffTree _wffTree) {
        this.truthValue = _truthValue;
        this.wffTree = _wffTree;
    }

    public LogicReturn (Boolean _truthValue, TruthTree _truthTree, WffTree _wffTree) {
        this.truthValue = _truthValue;
        this.truthTree = _truthTree;
        this.wffTree = _wffTree;
    }

    // Getters for object's attributes.
    public Boolean getTruthValue() {
        return truthValue;
    }

    public TruthTree getTruthTree() {
        return truthTree;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    public String getFormula() {
        return formula;
    }

    public ArrayList<NDWffTree> getNdWffTree() {
        return ndWffTree;
    }

    // Setters for object's attributes.
    public void setTruthValue(Boolean truthValue) {
        this.truthValue = truthValue;
    }

    public void setTruthTree(TruthTree truthTree) {
        this.truthTree = truthTree;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setNdWffTree(ArrayList<NDWffTree> ndWffTree) {
        this.ndWffTree = ndWffTree;
    }

}