package com.flat.view.main.panes.center.children.trees.base;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNode extends Text {
    private WffTree wffTree = null;
    private TreeNode ancestor = this;
    private TreeNode parent = null;
    private TreeNode thread = null;
    private int number = 1;
    private double mod = 0;
    private double change = 0;
    private double shift = 0;
    private ArrayList <TreeNode> children = new ArrayList();

    public TreeNode (WffTree _wffTree) {
        super.setText(_wffTree.getSymbol());
        super.setX(0);
        super.setY(0);
        this.wffTree = _wffTree;
        int counter = 1;
        TreeNode curNode;
        for (WffTree node : _wffTree.getChildren()) {
            curNode = new TreeNode(node);
            this.children.add(curNode);
            curNode.setTreeNodeParent(this);
            curNode.setNumber(counter);
            counter++;
        }
    }

    public WffTree getWffTree() {
        return wffTree;
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

    public TreeNode getAncestor () {
        return ancestor;
    }

    public TreeNode getTreeNodeParent () {
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

    public ArrayList <TreeNode> getTreeNodeChildren () {
        return children;
    }

    // Setters for object's attributes.
    public void setWffTree (WffTree wffTree) {
        this.wffTree = wffTree;
    }

    public void setAncestor(TreeNode ancestor) {
        this.ancestor = ancestor;
    }

    public void setTreeNodeParent (TreeNode parent) {
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

    public void setTreeNodeChildren (ArrayList <TreeNode> children) {
        this.children = children;
    }

}