package com.flat.view.main.panes.center.children.trees.base.treelayout;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxTreeNode extends TreeNode {
    private SimpleDoubleProperty centerX = new SimpleDoubleProperty();
    private SimpleDoubleProperty topCenterY = new SimpleDoubleProperty();
    private SimpleDoubleProperty bottomCenterY = new SimpleDoubleProperty();
    private ArrayList<Line> lines = new ArrayList();

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

    public void initializeLines () {
        this.addLines(this);
    }

    private void addLines (FxTreeNode _fxNode) {
        _fxNode.getChildren().forEach(child -> {
            Line line = new Line();
            line.startXProperty().bind(_fxNode.getCenterX());
            line.startYProperty().bind(_fxNode.getBottomCenterY());
            line.endXProperty().bind(((FxTreeNode)child).getCenterX());
            line.endYProperty().bind(((FxTreeNode)child).getTopCenterY());
            this.lines.add(line);
        });
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

    public ArrayList<Line> getLines() {
        return lines;
    }

}