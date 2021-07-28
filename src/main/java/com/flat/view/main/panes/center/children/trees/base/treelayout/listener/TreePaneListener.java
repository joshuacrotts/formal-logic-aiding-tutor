package com.flat.view.main.panes.center.children.trees.base.treelayout.listener;

import com.flat.controller.Controller;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.trees.base.treelayout.listener.events.TreeNodeLayoutSet;
import com.flat.view.main.panes.center.children.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.trees.base.treelayout.nodes.TreeNode;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class TreePaneListener implements EventListener {
    public Pane treePane;
    private FxTreeNode treeNode;

    public TreePaneListener (Pane _treePane) {
        this.treePane = _treePane;
        this.initializeFx();
    }

    private void initializeFx() {
        this.onThisFx();
    }

    private void onThisFx() {
            this.onThisScroll();
    }

    private void setTreeNodeLayout () {
        Controller.TREE_LAYOUT.execute(this.treeNode);
        Controller.EVENT_BUS.throwEvent(new TreeNodeLayoutSet());
    }

    protected void setTreeNodeFx () {
        this.resetScroll();
        this.addTreeNode(this.treeNode);
        this.addTreeNodeLines(this.treeNode);
    }

    private void addTreeNode (TreeNode _treeNode) {
        _treeNode.getTreeChildren().forEach(child -> {
            this.addTreeNode(child);
        });
        this.treePane.getChildren().add(_treeNode);
    }

    private void addTreeNodeLines (FxTreeNode _fxNode) {
        _fxNode.getTreeChildren().forEach(child -> {
            this.addTreeNodeLines((FxTreeNode)child);
        });
        _fxNode.getLines().forEach(line -> {
            this.treePane.getChildren().add(line);
        });
    }

    private void onThisScroll () {
        this.treePane.setOnScroll(event -> {
            double newScale = this.treePane.getScaleX();
            if (event.getDeltaY() > 0)
                newScale += .2;
            else
                newScale -= .2;
            if (newScale > .3 && newScale < 4) {
                this.treePane.setScaleX(newScale);
                this.treePane.setScaleY(newScale);
            }
            event.consume();
        });
    }

    private void resetScroll () {
        this.treePane.setScaleX(1);
        this.treePane.setScaleY(1);
    }

    private void onTreeNodeSize( ) {
        this.treeNode.heightProperty().addListener(event -> {
            this.setTreeNodeLayout();
        });
        this.treeNode.widthProperty().addListener(event -> {
            this.setTreeNodeLayout();
        });
    }

    // Getters for object's attributes.
    public FxTreeNode getTreeNode() {
        return treeNode;
    }

    // Setters for object's attributes.
    public void setTreeNode(FxTreeNode treeNode) {
        this.treeNode = treeNode;
        this.onTreeNodeSize();
        this.setTreeNodeFx();
    }

}