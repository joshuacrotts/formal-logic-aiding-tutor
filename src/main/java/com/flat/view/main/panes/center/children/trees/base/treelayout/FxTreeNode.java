package com.flat.view.main.panes.center.children.trees.base.treelayout;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.TextAlignment;

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
    // Size properties.
    private final SimpleDoubleProperty widthProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty heightProperty = new SimpleDoubleProperty();
    // Lines.
    private ArrayList<Line> lines = new ArrayList();
    // Highlight.
    private Rectangle highlightRectangle = null;

    public FxTreeNode (boolean _highlighted) {
        this.initializeFx();
        if (_highlighted)
            this.addHighlightRectangle();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setTextAlignment(TextAlignment.CENTER);
        super.setTextOrigin(VPos.CENTER);
        this.onLayoutBoundsProperty();
        this.setOnMouseDrag();
    }

    private void onLayoutBoundsProperty () {
        super.layoutBoundsProperty().addListener(listener -> {
            this.xMinProperty.set(super.getLayoutBounds().getMinX());
            this.xCenterProperty.set((super.getLayoutBounds().getMinX() + super.getLayoutBounds().getMaxX()) / 2);
            this.xMaxProperty.set(super.getLayoutBounds().getMaxX());
            this.yMinProperty.set(super.getLayoutBounds().getMinY());
            this.yMaxProperty.set(super.getLayoutBounds().getMaxY());
            this.widthProperty.set(super.getWidth());
            this.heightProperty.set(super.getHeight());
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
        this.addLines();
    }

    private void addLines () {
        this.getChildren().forEach(child -> {
            Line line = new Line();
            line.startXProperty().bind(this.xCenterProperty());
            line.startYProperty().bind(this.yMaxProperty());
            line.endXProperty().bind(((FxTreeNode)child).xCenterProperty());
            line.endYProperty().bind(((FxTreeNode)child).yMinProperty());
            this.lines.add(line);
        });
    }

    private void addHighlightRectangle () {
        this.highlightRectangle = new Rectangle();
        this.setHighlightRectangleStroke();
        this.setHighlightRectangleBounds();
    }

    private void setHighlightRectangleStroke () {
        this.highlightRectangle.setStrokeType(StrokeType.CENTERED);
        this.highlightRectangle.setStrokeLineCap(StrokeLineCap.ROUND);
        this.highlightRectangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
        this.highlightRectangle.setStrokeWidth(1);
        this.highlightRectangle.setStroke(Paint.valueOf("BLACK"));
        this.highlightRectangle.setFill(Paint.valueOf("YELLOW"));
    }

    private void setHighlightRectangleBounds () {
        this.highlightRectangle.xProperty().bind(this.xMinProperty);
        this.highlightRectangle.yProperty().bind(this.yMinProperty);
        this.highlightRectangle.widthProperty().bind(this.widthProperty);
        this.highlightRectangle.heightProperty().bind(this.heightProperty);
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

    public SimpleDoubleProperty widthProperty() {
        return widthProperty;
    }

    public SimpleDoubleProperty heightProperty() {
        return heightProperty;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Rectangle getHighlightRectangle() {
        return highlightRectangle;
    }

}