package com.flat.view.main.panes.center.children.trees.base.treelayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeLayout {
    private static double widthGap = 0;
    private static double heightGap = 0;
    private double currentWidth = 0;
    public TreeLayout (int _widthGap, int _heightGap) {
        this.widthGap = _widthGap;
        this.heightGap = _heightGap;
    }

    public void execute (TreeNode _treeNode) {
        this.currentWidth = 0;
        this.layoutWidth(_treeNode);
        this.executeShifts(_treeNode, 0);
        this.layoutHeight(_treeNode, _treeNode.getHeight());
    }

    public void layoutWidth (TreeNode _treeNode) {
        if (_treeNode.getChildren().isEmpty()) {
            if (_treeNode.getLeftSibling() != null)
                _treeNode.setX(_treeNode.getLeftSibling().getX() + _treeNode.getLeftSibling().getWidth() + this.widthGap);
            else
                _treeNode.setX(this.currentWidth);
            this.currentWidth += _treeNode.getWidth() + this.widthGap;
        }
        else {
            for (TreeNode child : _treeNode.getChildren()) {
                this.layoutWidth(child);
            }
            double midpoint = (_treeNode.getFirstChild().getX() + _treeNode.getLastChild().getX() + _treeNode.getLastChild().getWidth()) / 2;
            _treeNode.setX(midpoint - (_treeNode.getWidth()/ 2));
            if (_treeNode.getLeftSibling() != null) {
                double crossover = _treeNode.getX() - _treeNode.getLeftSibling().getX() - _treeNode.getLeftSibling().getWidth() - this.widthGap;
                if (crossover < 0) {
                    this.executeShifts(_treeNode, -crossover);
                }
            }
        }
    }

    private void executeShifts (TreeNode _treeNode, double _shift) {
        _treeNode.getChildren().forEach((child) -> {
            this.executeShifts(child, _shift);
        });
        _treeNode.setX(_treeNode.getX() + _shift);
    }

    public void layoutHeight (TreeNode _treeNode, double _height) {
        _treeNode.setY(_height);
        _treeNode.getChildren().forEach(child -> {
            this.layoutHeight(child, _height + _treeNode.getHeight() + this.heightGap);
        });
    }

    // Getters for object's attributes.
    public static double getWidthGap() {
        return widthGap;
    }

    public static double getHeightGap() {
        return heightGap;
    }

}