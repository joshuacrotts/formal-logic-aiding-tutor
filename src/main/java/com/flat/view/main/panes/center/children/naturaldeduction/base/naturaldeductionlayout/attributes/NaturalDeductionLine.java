package com.flat.view.main.panes.center.children.naturaldeduction.base.naturaldeductionlayout.attributes;

import com.flat.algorithms.models.NDWffTree;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionLine {
    private int line;
    private String wff;
    private String step;
    private String indices;

    public NaturalDeductionLine (int _line, NDWffTree _ndWffTree) {
        this.line = _line;
        this.wff = _ndWffTree.getWffTree().getStringRep();
        this.step = _ndWffTree.getDerivationStep().name();
        this.indices = _ndWffTree.getDerivedParentIndices().toString().substring(1, _ndWffTree.getDerivedParentIndices().toString().length() - 1);
    }

    // Getters for object's attributes.
    public int getLine() {
        return line;
    }

    public String getWff() {
        return wff;
    }

    public String getStep() {
        return step;
    }

    public String getIndices() {
        return indices;
    }

    // Setters for object's attributes.
    public void setLine(int line) {
        this.line = line;
    }

    public void setWff(String wff) {
        this.wff = wff;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setIndices(String indices) {
        this.indices = indices;
    }

}