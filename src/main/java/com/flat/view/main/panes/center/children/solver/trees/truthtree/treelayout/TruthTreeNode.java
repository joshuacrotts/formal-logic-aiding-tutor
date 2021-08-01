package com.flat.view.main.panes.center.children.solver.trees.truthtree.treelayout;

import com.flat.algorithms.models.TruthTree;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.attributes.TreeNodeText;
import javafx.scene.Node;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreeNode extends FxTreeNode {

    public TruthTreeNode (TruthTree _truthTree) {
        super(false, 50, 0);
        super.getChildren().add(new TreeNodeText(_truthTree.getWff().getStringRep()));
        if (_truthTree.getLeft() == null && _truthTree.getRight() == null) {
            this.addClosedProperty(_truthTree);
        }
        else {
            TruthTree curTree = _truthTree;
            while (curTree.getLeft() != null && curTree.getRight() == null) {
                super.getChildren().add(new TreeNodeText(curTree.getLeft().getWff().getStringRep()));
                curTree = curTree.getLeft();
            }
            if (curTree.getLeft() != null && curTree.getRight() != null && !curTree.equals(_truthTree)) {
                this.addChild(curTree.getLeft(), 1);
                this.addChild(curTree.getRight(), 2);
            } else if (!curTree.equals(_truthTree)) {
                this.addClosedProperty(curTree);
            }
            if (_truthTree.getLeft() != null && _truthTree.getRight() != null) {
                this.addChild(_truthTree.getLeft(), 1);
                this.addChild(_truthTree.getRight(), 2);
            }
        }
        double estimatedHeight = this.getEstimatedHeight();
        super.setMinHeight(estimatedHeight);
        super.setHeight(estimatedHeight);
        super.setMaxHeight(estimatedHeight);
        System.out.println(super.getHeight());
        super.initializeLines();
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getStyleClass().add("truthTreeNode");
    }

    private void addChild (TruthTree _truthTree, int _number) {
        TruthTreeNode _truthNode = new TruthTreeNode(_truthTree);
        _truthNode.setTreeParent(this);
        _truthNode.setNumber(_number);
        this.getTreeChildren().add(_truthNode);
    }

    private void addClosedProperty (TruthTree _truthTree) {
        super.getChildren().add(new TreeNodeText((_truthTree.isClosed()) ? "Closed" : "Open"));
    }

    private double getEstimatedHeight () {
        double height = 0;
        for (Node node : super.getChildren()) {
            height += ((TreeNodeText)node).getLayoutBounds().getHeight();
            height += super.getSpacing();
        }
        if (height != 0)
            height -= super.getSpacing();
        return height;
    }

}