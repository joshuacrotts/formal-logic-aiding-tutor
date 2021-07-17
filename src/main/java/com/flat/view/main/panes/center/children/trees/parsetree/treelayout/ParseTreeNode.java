package com.flat.view.main.panes.center.children.trees.parsetree.treelayout;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeNode;
import javafx.geometry.Point2D;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeNode extends TreeNode {

    public ParseTreeNode(WffTree _wffTree) {
        super.setText(_wffTree.getSymbol());
        int counter = 1;
        ParseTreeNode curNode;
        for (WffTree wffTree : _wffTree.getChildren()) {
            curNode = new ParseTreeNode(wffTree);
            curNode.setParent(this);
            curNode.setNumber(counter);
            this.getChildren().add(curNode);
            counter++;
        }
        this.setOnMouseDrag();
    }

    private void setOnMouseDrag () {
        super.setOnMouseDragged(event -> {
            Point2D sceneToLocal = super.sceneToLocal(event.getSceneX(), event.getSceneY());
            double deltaX = super.getX() - sceneToLocal.getX();
            double deltaY = super.getY() - sceneToLocal.getY();
            this.moveSubTree(this, deltaX, deltaY);
        });
    }

    private void moveSubTree (TreeNode _treeNode, double _deltaX, double _deltaY) {
        _treeNode.getChildren().forEach(child -> {
            this.moveSubTree(child, _deltaX, _deltaY);
        });
        _treeNode.setX(_treeNode.getX() - _deltaX);
        _treeNode.setY(_treeNode.getY() - _deltaY);
    }

}