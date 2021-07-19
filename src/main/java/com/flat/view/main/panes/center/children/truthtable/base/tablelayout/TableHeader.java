package com.flat.view.main.panes.center.children.truthtable.base.tablelayout;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableHeader {
    private int column;
    private String text;
    private ArrayList <TableElement> elements = new ArrayList();

    public TableHeader (int _column, String _text, ArrayList <TableElement> _elements) {
        this.column = _column;
        this.text = _text;
        this.elements = _elements;
    }

    // Getters for object's attributes.
    public int getColumn() {
        return column;
    }

    public String getText() {
        return text;
    }

    public ArrayList<TableElement> getElements() {
        return elements;
    }

    // Setters for object's attributes.
    public void setColumn(int column) {
        this.column = column;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setElements(ArrayList<TableElement> elements) {
        this.elements = elements;
    }

}