package com.flat.view.main.panes.center.children.truthtable.base.tablelayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableElement {
    private int row;
    private int column;
    private String text;

    public TableElement (int _row, int _column, String _text) {
        this.row = _row;
        this.column = _column;
        this.text = _text;
    }

    // Getters for object's attributes.
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getText() {
        return text;
    }

    // Setters for object's attributes.
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setText(String text) {
        this.text = text;
    }

}