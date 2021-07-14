package com.flat.view.main.panes.center.children.trees.base;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNode {
    private String text;
    private TreeNode ancestor = this;
    private TreeNode parent = null;
    private TreeNode thread = null;
    private int number = 1;
    private double mod = 0;
    private double change = 0;
    private double shift = 0;
    private double x = 0;
    private double y = 0;
    private double width = 0;
    private double height = 0;
    private ArrayList <TreeNode> children = new ArrayList();

    public TreeNode (WffTree _wffTree) {
        this.text = _wffTree.getStringRep();
        this.width = new Text(this.text).getLayoutBounds().getWidth();
        this.height = new Text(this.text).getLayoutBounds().getHeight();
        int counter = 1;
        TreeNode curNode;
        for (WffTree wffTree : _wffTree.getChildren()) {
            curNode = new TreeNode(wffTree);
            curNode.setParent(this);
            curNode.setNumber(counter);
            this.children.add(curNode);
            counter++;
        }
    }

    public TreeNode getLeftMostSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(0);
        return null;
    }

    public TreeNode getLeftSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(this.number - 2);
        return null;
    }

    public TreeNode getRightMostSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.parent.children.size() - 1);
        return null;
    }

    public TreeNode getRightSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.number);
        return null;
    }

    // Getters for object's attributes.
    public TreeNode getFirstChild () {
        return this.children.isEmpty() ? null : this.children.get(0);
    }

    public TreeNode getLastChild () {
        return this.children.isEmpty() ? null : this.children.get(this.children.size() - 1);
    }

    public TreeNode getNextRight () {
        return this.getLastChild() != null ? this.getLastChild() : this.thread;
    }

    public TreeNode getNextLeft () {
        return this.getFirstChild() != null ? this.getFirstChild() : this.thread;
    }

    public String getText () {
        return text;
    }

    public TreeNode getAncestor () {
        return ancestor;
    }

    public TreeNode getParent () {
        return parent;
    }

    public TreeNode getThread () {
        return thread;
    }

    public int getNumber () {
        return number;
    }

    public double getMod () {
        return mod;
    }

    public double getChange () {
        return change;
    }

    public double getShift () {
        return shift;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public double getWidth () {
        return width;
    }

    public double getHeight () {
        return height;
    }

    public ArrayList <TreeNode> getChildren () {
        return children;
    }

    // Setters for object's attributes.
    public void setText (String text) {
        this.text = text;
    }

    public void setAncestor (TreeNode ancestor) {
        this.ancestor = ancestor;
    }

    public void setParent (TreeNode parent) {
        this.parent = parent;
    }

    public void setThread (TreeNode thread) {
        this.thread = thread;
    }

    public void setNumber (int number) {
        this.number = number;
    }

    public void setMod (double mod) {
        this.mod = mod;
    }

    public void setChange (double change) {
        this.change = change;
    }

    public void setShift (double shift) {
        this.shift = shift;
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public void setWidth (double width) {
        this.width = width;
    }

    public void setHeight (double height) {
        this.height = height;
    }

    public void setChildren (ArrayList <TreeNode> children) {
        this.children = children;
    }

}