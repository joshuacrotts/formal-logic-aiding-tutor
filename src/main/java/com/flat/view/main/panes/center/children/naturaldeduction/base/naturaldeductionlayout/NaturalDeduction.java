package com.flat.view.main.panes.center.children.naturaldeduction.base.naturaldeductionlayout;

import com.flat.algorithms.models.NDWffTree;
import com.flat.view.main.panes.center.children.naturaldeduction.base.naturaldeductionlayout.attributes.NaturalDeductionLine;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeduction {
    private ArrayList <NDWffTree> ndWffTrees;
    private ArrayList <NaturalDeductionLine> lines = new ArrayList();

    public NaturalDeduction (ArrayList <NDWffTree> _ndWffTree) {
        this.ndWffTrees = _ndWffTree;
        this.setLayout();
    }

    private void setLayout () {
        int counter = 0;
        for (NDWffTree ndWffTree : ndWffTrees) {
            this.lines.add(counter, new NaturalDeductionLine(counter, ndWffTree));
            counter++;
        }
    }

    // Getters for object's attributes.
    public ArrayList<NDWffTree> getNdWffTrees() {
        return ndWffTrees;
    }

    public ArrayList<NaturalDeductionLine> getLines() {
        return lines;
    }

    // Setters for object's attributes.
    public void setNdWffTrees(ArrayList<NDWffTree> ndWffTrees) {
        this.ndWffTrees = ndWffTrees;
    }

    public void setLines(ArrayList<NaturalDeductionLine> lines) {
        this.lines = lines;
    }

}