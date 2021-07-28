package com.flat.view.main.panes.center.children.trees.base.treelayout.nodes;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class TreeNode extends VBox {
    private TreeNode treeParent = null;
    private int number = 1;
    private double shift = 0;
    private ArrayList <TreeNode> treeChildren = new ArrayList();

    // Additional getters for object's attributes.
    public final TreeNode getLeftMostSibling () {
        if (this.treeParent != null && this.number > 1)
            return this.treeParent.treeChildren.get(0);
        return null;
    }

    public final TreeNode getRightMostSibling () {
        if (this.treeParent != null)
            if (this.treeParent.treeChildren.size() > this.number)
                return this.treeParent.treeChildren.get(this.treeParent.treeChildren.size() - 1);
        return null;
    }

    public final TreeNode getLeftSibling () {
        if (this.treeParent != null && this.number > 1)
            return this.treeParent.treeChildren.get(this.number - 2);
        return null;
    }

    public final TreeNode getRightSibling () {
        if (this.treeParent != null)
            if (this.treeParent.treeChildren.size() > this.number)
                return this.treeParent.treeChildren.get(this.number);
        return null;
    }

    public final TreeNode getFirstChild () {
        return this.treeChildren.isEmpty() ? null : this.treeChildren.get(0);
    }

    public final TreeNode getLastChild () {
        return this.treeChildren.isEmpty() ? null : this.treeChildren.get(this.treeChildren.size() - 1);
    }

    // Getters for object's attributes.
    public TreeNode getTreeParent() {
        return treeParent;
    }

    public int getNumber() {
        return number;
    }

    public double getShift() {
        return shift;
    }

    public ArrayList<TreeNode> getTreeChildren() {
        return treeChildren;
    }

    // Setters for object's attributes.
    public void setTreeParent(TreeNode treeParent) {
        this.treeParent = treeParent;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setShift(double shift) {
        this.shift = shift;
    }

    public void setTreeChildren(ArrayList<TreeNode> treeChildren) {
        this.treeChildren = treeChildren;
    }

}