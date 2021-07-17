package com.flat.view.main.panes.center.children.trees.base.treelayout;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNode extends Text {
    private TreeNode parent = null;
    private int number = 1;
    private double shift = 0;
    private ArrayList <TreeNode> children = new ArrayList();

    public TreeNode () {
    }

    public TreeNode (WffTree _wffTree) {
        super.setText(_wffTree.toString());
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

    // Getters for object's attributes.
    public final TreeNode getLeftMostSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(0);
        return null;
    }

    public final TreeNode getRightMostSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.parent.children.size() - 1);
        return null;
    }

    public final TreeNode getLeftSibling () {
        if (this.parent != null && this.number > 1)
            return this.parent.children.get(this.number - 2);
        return null;
    }

    public final TreeNode getRightSibling () {
        if (this.parent != null)
            if (this.parent.children.size() > this.number)
                return this.parent.children.get(this.number);
        return null;
    }

    public final TreeNode getFirstChild () {
        return this.children.isEmpty() ? null : this.children.get(0);
    }

    public final TreeNode getLastChild () {
        return this.children.isEmpty() ? null : this.children.get(this.children.size() - 1);
    }

    public final int getNumber () {
        return number;
    }

    public final double getShift () {
        return shift;
    }

    public final ArrayList <TreeNode> getChildren () {
        return children;
    }

    public final double getWidth () {
        return super.getLayoutBounds().getWidth();
    }

    public final double getHeight () {
        return super.getLayoutBounds().getHeight();
    }

    public TreeNode getTreeNodeParent() {
        return parent;
    }

    // Setters for object's attributes.
    protected final void setParent (TreeNode parent) {
        this.parent = parent;
    }

    protected final void setNumber (int number) {
        this.number = number;
    }

    protected final void setShift (double shift) {
        this.shift = shift;
    }

    protected final void setChildren (ArrayList <TreeNode> children) {
        this.children = children;
    }

}