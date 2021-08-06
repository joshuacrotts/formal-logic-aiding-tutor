package com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableElement {

    public enum Type {
        HORIZONTAL,
        VERTICAL,
        REGULAR,
    }

    private int row;
    private Boolean truthValue;
    private String text;
    private Type type = Type.REGULAR;

    public TableElement (int _row, String _text) {
        this.row = _row;
        this.truthValue = null;
        this.text = _text;
    }

    public TableElement (int _row, Type _type) {
        this.row = _row;
        this.truthValue = null;
        this.type = _type;
        switch (_type) {
            case HORIZONTAL:
                this.text = "―";
                break;
            case VERTICAL:
                this.text = "｜";
        }
    }

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

    public Type getType() {
        return type;
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