package com.flat.models.buchheim;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BuchheimNode {
    private String text;
    private BuchheimNode ancestor = this;
    private BuchheimNode parent = null;
    private BuchheimNode thread = null;
    private int number = 1;
    private double mod = 0;
    private double change = 0;
    private double shift = 0;
    private double x = 0;
    private double y = 0;
    private double width = 0;
    private double height = 0;
    private ArrayList<BuchheimNode> children = new ArrayList();

    public BuchheimNode (String _text, BuchheimNode... _children) {
        this.text = _text;
        this.width = new Text(_text).getLayoutBounds().getWidth();
        this.height = new Text(_text).getLayoutBounds().getHeight();
        children.addAll(Arrays.asList(_children));
        int counter = 1;
        for (BuchheimNode node : children) {
            node.setParent(this);
            node.setNumber(counter);
            counter++;
        }
    }

    public BuchheimNode getLeftMostSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(0);
        return null;
    }

    public BuchheimNode getLeftSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(this.number - 2);
        return null;
    }

    public BuchheimNode getRightMostSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.parent.children.size() - 1);
        return null;
    }

    public BuchheimNode getRightSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.number);
        return null;
    }

    // Getters for object's attributes.
    public BuchheimNode getFirstChild () {
        return this.children.isEmpty() ? null : this.children.get(0);
    }

    public BuchheimNode getLastChild () {
        return this.children.isEmpty() ? null : this.children.get(this.children.size() - 1);
    }

    public BuchheimNode getNextRight() {
        return this.getLastChild() != null ? this.getLastChild() : this.thread;
    }

    public BuchheimNode getNextLeft() {
        return this.getFirstChild() != null ? this.getFirstChild() : this.thread;
    }

    public String getText() {
        return text;
    }

    public BuchheimNode getAncestor() {
        return ancestor;
    }

    public BuchheimNode getParent() {
        return parent;
    }

    public BuchheimNode getThread() {
        return thread;
    }

    public int getNumber() {
        return number;
    }

    public double getMod() {
        return mod;
    }

    public double getChange() {
        return change;
    }

    public double getShift() {
        return shift;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public ArrayList<BuchheimNode> getChildren() {
        return children;
    }

    // Setters for object's attributes.
    public void setText(String text) {
        this.text = text;
    }

    public void setAncestor(BuchheimNode ancestor) {
        this.ancestor = ancestor;
    }

    public void setParent(BuchheimNode parent) {
        this.parent = parent;
    }

    public void setThread(BuchheimNode thread) {
        this.thread = thread;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMod(double mod) {
        this.mod = mod;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setShift(double shift) {
        this.shift = shift;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setChildren(ArrayList<BuchheimNode> children) {
        this.children = children;
    }

}