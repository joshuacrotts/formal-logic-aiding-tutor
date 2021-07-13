/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flat.models.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.models.treenode.WffTree;

/**
 *
 * @author christopherbrantley
 */
public class LogicReturn {
    private boolean truthValue;
    private TruthTree truthTree;
    private WffTree wffTree;

    public LogicReturn (boolean _truthValue, TruthTree _truthTree, WffTree _wffTree) {
        this.truthValue = _truthValue;
        this.truthTree = _truthTree;
        this.wffTree = _wffTree;
    }

    // Getters for object's attributes.
    public boolean isTruthValue() {
        return truthValue;
    }

    public TruthTree getTruthTree() {
        return truthTree;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setTruthValue(boolean truthValue) {
        this.truthValue = truthValue;
    }

    public void setTruthTree(TruthTree truthTree) {
        this.truthTree = truthTree;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

}