package com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.css.PseudoClass;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxTreeNode extends TreeNode {
    // X properties.
    private final SimpleDoubleProperty xMinProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty xCenterProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty xMaxProperty = new SimpleDoubleProperty();
    // Y properties.
    private final SimpleDoubleProperty yMinProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty yMaxProperty = new SimpleDoubleProperty();
    // Lines.
    private ArrayList<Line> lines = new ArrayList();

    public FxTreeNode (boolean _highlighted, double _minWidth, double _minHeight) {
        if (_highlighted)
            this.setHighlightedFx();
        super.setMinSize(_minWidth, _minHeight);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.onBoundsInParent();
        this.setOnMouseDrag();
        super.getStyleClass().clear();
        super.getStyleClass().add("fxTreeNode");
    }

    private void onBoundsInParent () {
        super.boundsInParentProperty().addListener(listener -> {
            this.xMinProperty.set(super.getBoundsInParent().getMinX());
            this.xCenterProperty.set((super.getBoundsInParent().getMinX() + super.getBoundsInParent().getMaxX()) / 2);
            this.xMaxProperty.set(super.getBoundsInParent().getMaxX());
            this.yMinProperty.set(super.getBoundsInParent().getMinY());
            this.yMaxProperty.set(super.getBoundsInParent().getMaxY());
        });
    }

    private void setOnMouseDrag () {
        super.setOnMouseDragged(event -> {
            Point2D sceneToLocal = super.sceneToLocal(event.getSceneX(), event.getSceneY());
            double deltaX = super.getBoundsInLocal().getMinX()- sceneToLocal.getX();
            double deltaY = super.getBoundsInLocal().getMinY()- sceneToLocal.getY();
            this.moveSubTree(this, deltaX, deltaY);
        });
    }

    private void moveSubTree (TreeNode _treeNode, double _deltaX, double _deltaY) {
        _treeNode.getTreeChildren().forEach(child -> {
            this.moveSubTree(child, _deltaX, _deltaY);
        });
        _treeNode.setTranslateX(_treeNode.getTranslateX() - _deltaX);
        _treeNode.setTranslateY(_treeNode.getTranslateY() - _deltaY);
    }

    public void initializeLines () {
        this.addLines();
    }

    private void addLines () {
        this.getTreeChildren().forEach(child -> {
            Line line = new Line();
            line.startXProperty().bind(this.xCenterProperty());
            line.startYProperty().bind(this.yMaxProperty());
            line.endXProperty().bind(((FxTreeNode)child).xCenterProperty());
            line.endYProperty().bind(((FxTreeNode)child).yMinProperty());
            this.lines.add(line);
        });
    }

    private void setHighlightedFx () {
        super.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), true);
    }

    // Getters for object's attributes.
    public SimpleDoubleProperty xMinProperty() {
        return xMinProperty;
    }

    public SimpleDoubleProperty xCenterProperty() {
        return xCenterProperty;
    }

    public SimpleDoubleProperty xMaxProperty() {
        return xMaxProperty;
    }

    public SimpleDoubleProperty yMinProperty() {
        return yMinProperty;
    }

    public SimpleDoubleProperty yMaxProperty() {
        return yMaxProperty;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}