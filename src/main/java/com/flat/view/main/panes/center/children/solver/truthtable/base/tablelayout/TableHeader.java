package com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableHeader {
    private int column;
    private String text;
    private ArrayList <TableElement> elements = new ArrayList();

    public TableHeader (int _column, String _text) {
        this.column = _column;
        this.text = _text;
    }

    public TableHeader (int _column, String _text, WffTree _wffTree) {
        this.column = _column;
        this.text = _text;
        this.addElements(_wffTree);
    }

    private void addElements (WffTree _wffTree) {
        _wffTree.getTruthValues().forEach(truth -> {
            this.elements.add(new TableElement(this.elements.size() + 1, truth));
        });
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