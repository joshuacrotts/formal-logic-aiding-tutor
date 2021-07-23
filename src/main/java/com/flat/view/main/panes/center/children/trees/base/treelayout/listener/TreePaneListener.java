package com.flat.view.main.panes.center.children.trees.base.treelayout.listener;

import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.trees.base.treelayout.FxTreeNode;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeNode;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class TreePaneListener implements EventListener {
    public Pane treePane;

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

    protected void addNodes (TreeNode _treeNode) {
        _treeNode.getChildren().forEach(treeNode -> {
            this.addNodes(treeNode);
        });
        this.treePane.getChildren().add(_treeNode);
    }

    protected void addLines (FxTreeNode _fxNode) {
        _fxNode.getChildren().forEach(child -> {
            this.addLines((FxTreeNode)child);
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

}