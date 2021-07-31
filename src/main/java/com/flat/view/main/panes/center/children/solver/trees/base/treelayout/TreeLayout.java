package com.flat.view.main.panes.center.children.solver.trees.base.treelayout;

import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.TreeNode;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeLayout {
    private static double WIDTH_GAP = 0;
    private static double HEIGHT_GAP = 0;
    private double currentWidth = 0;

    public TreeLayout (int _widthGap, int _heightGap) {
        TreeLayout.WIDTH_GAP = _widthGap;
        TreeLayout.HEIGHT_GAP = _heightGap;
    }

    public void execute (TreeNode _treeNode) {
        this.currentWidth = 0;
        this.layoutWidth(_treeNode);
        this.executeShifts(_treeNode, 0);
        this.layoutHeight(_treeNode, _treeNode.getBoundsInParent().getHeight());
    }

    public void layoutWidth (TreeNode _treeNode) {
        if (_treeNode.getTreeChildren().isEmpty()) {
            if (_treeNode.getLeftSibling() != null)
                _treeNode.setLayoutX(this.currentWidth);
            else
                _treeNode.setLayoutX(this.currentWidth);
            this.currentWidth = _treeNode.getBoundsInParent().getMaxX() + TreeLayout.WIDTH_GAP;
        }
        else {
            for (TreeNode child : _treeNode.getTreeChildren()) {
                this.layoutWidth(child);
            }
            double midpoint = (_treeNode.getFirstChild().getLayoutX() + _treeNode.getLastChild().getLayoutX() + _treeNode.getLastChild().getBoundsInParent().getWidth()) / 2;
            _treeNode.setLayoutX(midpoint - (_treeNode.getBoundsInParent().getWidth()/ 2));
            if (_treeNode.getLeftSibling() != null) {
                double crossover = _treeNode.getLayoutX() - _treeNode.getLeftSibling().getLayoutX() - _treeNode.getLeftSibling().getBoundsInParent().getWidth() - TreeLayout.WIDTH_GAP;
                if (crossover < 0) {
                    this.executeShifts(_treeNode, -crossover);
                }
            }
            if (_treeNode.getBoundsInParent().getMaxX() + TreeLayout.WIDTH_GAP > this.currentWidth)
                this.currentWidth = _treeNode.getBoundsInParent().getMaxX() + TreeLayout.WIDTH_GAP;
        }
    }

    private void executeShifts (TreeNode _treeNode, double _shift) {
        _treeNode.getTreeChildren().forEach((child) -> {
            this.executeShifts(child, _shift);
        });
        _treeNode.setLayoutX(_treeNode.getLayoutX() + _shift);
    }

    public void layoutHeight (TreeNode _treeNode, double _height) {
        _treeNode.setLayoutY(_height);
        _treeNode.getTreeChildren().forEach(child -> {
            this.layoutHeight(child, _height + _treeNode.getBoundsInParent().getHeight() + TreeLayout.HEIGHT_GAP);
        });
    }

    // Getters for object's attributes.
    public static double getWIDTH_GAP() {
        return WIDTH_GAP;
    }

    public static double getHEIGHT_GAP() {
        return HEIGHT_GAP;
    }

}