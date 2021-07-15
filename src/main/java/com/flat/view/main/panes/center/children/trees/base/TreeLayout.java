package com.flat.view.main.panes.center.children.trees.base;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeLayout {
    private double widthGap = 0;
    private double heightGap = 0;
    private double currentWidth = 0;
    public TreeLayout (int _widthGap, int _heightGap) {
        this.widthGap = _widthGap;
        this.heightGap = _heightGap;
    }

    public void execute (TreeNode _treeNode) {
        this.currentWidth = 0;
        this.layoutWidth(_treeNode);
        this.executeShifts(_treeNode, 0);
        this.layoutHeight(_treeNode, 0);
    }

    public void layoutWidth (TreeNode _treeNode) {
        System.out.println("Node: " + _treeNode.getText());
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
                System.out.println("Crossover: " + crossover);
                if (crossover < 0) {
                    double halfCrossover = crossover / 2;
                    this.executeShifts(_treeNode.getLeftSibling(), halfCrossover);
                    this.executeShifts(_treeNode, -halfCrossover);
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

}