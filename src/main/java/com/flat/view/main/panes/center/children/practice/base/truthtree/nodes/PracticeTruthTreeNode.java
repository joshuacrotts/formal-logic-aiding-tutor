package com.flat.view.main.panes.center.children.practice.base.truthtree.nodes;

import com.flat.algorithms.models.TruthTree;
import com.flat.view.main.panes.center.children.practice.base.truthtree.nodes.children.TreeNodePracticeText;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.TreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.attributes.TreeNodeText;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeTruthTreeNode extends FxTreeNode {
    private TreeNodePracticeText practiceNode = null;

    public PracticeTruthTreeNode (TruthTree _truthTree) {
        super(false);
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
        super.initializeLines();
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setSpacing(0);
        super.setPadding(new Insets(0));
        double estimatedHeight = this.getEstimatedHeight();
        super.setMinHeight(estimatedHeight);
        super.setHeight(estimatedHeight);
        super.setMaxHeight(estimatedHeight);
        double estimatedWidth = this.getEstimatedWidth();
        super.setMinWidth(estimatedWidth);
        super.setWidth(estimatedWidth);
        super.setMaxWidth(estimatedWidth);
        super.getStyleClass().add("truthTreeNode");
    }

    private void addChild (TruthTree _truthTree, int _number) {
        PracticeTruthTreeNode _truthNode = new PracticeTruthTreeNode(_truthTree);
        _truthNode.setTreeParent(this);
        _truthNode.setNumber(_number);
        this.getTreeChildren().add(_truthNode);
    }

    private double getEstimatedHeight () {
        double height = 0;
        for (Node node : super.getChildren()) {
            height += ((Text)node).getLayoutBounds().getHeight();
            height += super.getSpacing();
        }
        if (height != 0)
            height -= super.getSpacing();
        return height;
    }

    private double getEstimatedWidth () {
        double width = 0;
        for (Node node: super.getChildren()) {
            width = Math.max(width, ((Text)node).getLayoutBounds().getWidth());
        }
        return width;
    }

    protected void addClosedProperty(TruthTree _truthTree) {
        TreeNodePracticeText node = new TreeNodePracticeText(_truthTree.isClosed());
        super.getChildren().add(node);
        this.practiceNode = node;
    }

    public boolean checkPractice () {
        boolean returnValue = true;
        for (TreeNode node : super.getTreeChildren())
            returnValue = returnValue & ((PracticeTruthTreeNode)node).checkPractice();
        if (this.practiceNode != null)
            return returnValue & this.practiceNode.checkAnswer();
        else
            return returnValue;

    }

    @Override
    protected void setOnMouseDrag() {
    }

}