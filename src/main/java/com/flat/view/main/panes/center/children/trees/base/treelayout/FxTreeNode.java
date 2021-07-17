package com.flat.view.main.panes.center.children.trees.base.treelayout;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxTreeNode extends TreeNode {
    private SimpleDoubleProperty centerX = new SimpleDoubleProperty();
    private SimpleDoubleProperty topCenterY = new SimpleDoubleProperty();
    private SimpleDoubleProperty bottomCenterY = new SimpleDoubleProperty();

    public FxTreeNode () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.onLayoutBoundsProperty();
        this.setOnMouseDrag();
    }

    private void onLayoutBoundsProperty () {
        super.layoutBoundsProperty().addListener(listener -> {
            this.centerX.set((super.getLayoutBounds().getMinX() + super.getLayoutBounds().getMaxX()) / 2);
            this.topCenterY.set(super.getLayoutBounds().getMinY());
            this.bottomCenterY.set(super.getLayoutBounds().getMaxY());
        });
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

    // Getters for object's attributes.
    public SimpleDoubleProperty getCenterX() {
        return centerX;
    }

    public SimpleDoubleProperty getTopCenterY() {
        return topCenterY;
    }

    public SimpleDoubleProperty getBottomCenterY() {
        return bottomCenterY;
    }

}