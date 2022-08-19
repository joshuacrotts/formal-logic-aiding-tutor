package com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout;

import com.flat.models.treenode.WffTree;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TableHeader {

    public enum Type {
        VERTICAL,
        REGULAR,
        PARENTHETICAL_OPEN,
        PARENTHETICAL_CLOSE,
    }

    private int column;
    private String text;
    private ArrayList <TableElement> elements = new ArrayList();
    private Type type = Type.REGULAR;
    private ArrayList <Integer> childIndexes = new ArrayList();

    public TableHeader (int _column, Type _type, int _eltRepeat) {
        this.column = _column;
        this.type = _type;
        switch (_type) {
            case VERTICAL:
                this.text = "|";
                break;
            case PARENTHETICAL_OPEN:
                this.text = "(";
                this.addHorizontalSeparator();
                break;
            case PARENTHETICAL_CLOSE:
                this.text = ")";
                this.addHorizontalSeparator();
                break;
        }
        this.addElements(_eltRepeat);
    }

    public TableHeader (int _column, String _text, WffTree _wffTree) {
        this.column = _column;
        this.text = _text;
        this.addHorizontalSeparator();
        this.addElements(_wffTree);
    }

    private void addElements (WffTree _wffTree) {
        _wffTree.getTruthValues().forEach(truth -> {
            this.elements.add(new TableElement(this.elements.size() + 1, truth));
        });
    }

    private void addElements (int _size) {
        while (_size-- > 0)
            this.elements.add(new TableElement(this.elements.size() + 1, this.text));
    }

    private void addHorizontalSeparator () {
        this.elements.add(new TableElement(this.elements.size() + 1, TableElement.Type.HORIZONTAL));
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

    public Type getType() {
        return type;
    }

    public ArrayList<Integer> getChildIndexes() {
        return childIndexes;
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

    public void setChildIndexes(ArrayList<Integer> childIndexes) {
        this.childIndexes = childIndexes;
    }

}