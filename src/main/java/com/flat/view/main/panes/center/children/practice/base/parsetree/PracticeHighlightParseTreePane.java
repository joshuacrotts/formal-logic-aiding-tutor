package com.flat.view.main.panes.center.children.practice.base.parsetree;

import com.flat.controller.Controller;
import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.parsetree.nodes.PracticeParseTreeNode;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.listener.events.TreeNodeLayoutSet;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.TreeNode;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeHighlightParseTreePane extends Pane implements Practice {
    private PracticeParseTreeNode practiceNode;
    private WffTree wffTree;

    public PracticeHighlightParseTreePane (WffTree _wffTree) {
        this.initializeFx();
        this.setWffTree(_wffTree);
        Controller.DATA_BUS.throwUpdate(new PracticePaneUpdate(this));
    }

    private void initializeFx() {
        this.onThisFx();
    }

    private void onThisFx() {
        this.onThisScroll();
    }

    private void setTreeNodeLayout () {
        Controller.TREE_LAYOUT.execute(this.practiceNode);
        Controller.EVENT_BUS.throwEvent(new TreeNodeLayoutSet());
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

    private boolean checkHighlights (PracticeParseTreeNode _node) {
        boolean truth = true;
        for (TreeNode child : _node.getTreeChildren())
            truth = truth && this.checkHighlights((PracticeParseTreeNode)child);
        return (_node.isHighlighted() == _node.getWffTree().isHighlighted()) && truth;
    }

    // Getters for object's attributes.
    public PracticeParseTreeNode getPracticeNode() {
        return practiceNode;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setPracticeNode(PracticeParseTreeNode practiceNode) {
        this.practiceNode = practiceNode;
        this.setTreeNodeFx();
        this.setTreeNodeLayout();
    }

    public final void setWffTree(WffTree _wffTree) {
        this.wffTree = _wffTree;
        this.setPracticeNode(new PracticeParseTreeNode(_wffTree));
    }

    @Override
    public boolean getResult() {
        return this.checkHighlights(this.practiceNode);
    }

}