package com.flat.input.events;

import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SolvedFormula extends Event {
    private ArrayList <WffTree> wffTree;

    public SolvedFormula(ArrayList <WffTree> _wffTree) {
        super(Event.Type.SOLVED_FORMULA);
        this.wffTree = _wffTree;
    }

    // Getters for object's attributes.
    public ArrayList<WffTree> getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setWffTree(ArrayList<WffTree> wffTree) {
        this.wffTree = wffTree;
    }

}