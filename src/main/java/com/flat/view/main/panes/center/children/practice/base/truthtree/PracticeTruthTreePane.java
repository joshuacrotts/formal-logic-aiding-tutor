package com.flat.view.main.panes.center.children.practice.base.truthtree;

import com.flat.algorithms.models.TruthTree;
import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.truthtree.nodes.PracticeTruthTreeNode;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.TreeNode;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */

public class PracticeTruthTreePane extends Pane implements Practice {
    private TruthTree truthTree;
    private PracticeTruthTreeNode practiceNode = null;

    public PracticeTruthTreePane (TruthTree _truthTree) {
        this.truthTree = _truthTree;
        this.practiceNode = new PracticeTruthTreeNode(_truthTree);
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticePaneUpdate(this));
    }

    private void initializeFx() {
        this.onThisFx();
    }

    private void onThisFx() {
        this.onThisScroll();
        this.setTreeNodeFx();
        this.setTreeNodeLayout();
    }

    private void onThisScroll () {
        this.setOnScroll(event -> {
            double newScale = this.getScaleX();
            if (event.getDeltaY() > 0)
                newScale += .2;
            else
                newScale -= .2;
            if (newScale > .3 && newScale < 4) {
                this.setScaleX(newScale);
                this.setScaleY(newScale);
            }
            event.consume();
        });
    }

    private void setTreeNodeLayout () {
        Controller.TREE_LAYOUT.execute(this.practiceNode);
    }

    protected void setTreeNodeFx () {
        this.addTreeNode(this.practiceNode);
        this.addTreeNodeLines(this.practiceNode);
    }

    private void addTreeNode (TreeNode _treeNode) {
        _treeNode.getTreeChildren().forEach(child -> {
            this.addTreeNode(child);
        });
        this.getChildren().add(_treeNode);
    }

    private void addTreeNodeLines (FxTreeNode _fxNode) {
        _fxNode.getTreeChildren().forEach(child -> {
            this.addTreeNodeLines((FxTreeNode)child);
        });
        _fxNode.getLines().forEach(line -> {
            this.getChildren().add(line);
        });
    }

    @Override
    public boolean getResult() {
        return this.practiceNode.checkPractice();
    }

    @Override
    public void setUserAnswer(Object _answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}