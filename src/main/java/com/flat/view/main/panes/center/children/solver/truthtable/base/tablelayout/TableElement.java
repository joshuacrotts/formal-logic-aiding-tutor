package com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableElement {
    private int row;
    private boolean truthValue;
    private String text;

    public TableElement (int _row, boolean _truthValue) {
        this.row = _row;
        this.truthValue = _truthValue;
        this.setText(_truthValue);
    }

    // Getters for object's attributes.
    public int getRow () {
        return row;
    }

    public boolean getTruthValue() {
        return truthValue;
    }

    public String getText () {
        return text;
    }

    // Setters for object's attributes.
    public void setRow (int row) {
        this.row = row;
    }

    public void setTruthValue(boolean truthValue) {
        this.truthValue = truthValue;
    }

    public final void setText (boolean text) {
        if (text)
            this.text = "T";
        else
            this.text = "F";
    }

}