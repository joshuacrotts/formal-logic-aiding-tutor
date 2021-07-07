package com.flat.models.buchheim;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Buchheim {
    private int widthGap = 0;
    private int heightGap = 0;
    private double maxWidth = 0;

    public Buchheim(int _widthGap, int _heightGap) {
        this.widthGap = _widthGap;
        this.heightGap = _heightGap;
    }

    public void execute (BuchheimNode _node) {
        this.firstWalk(_node);
        double min = this.secondWalk(_node, 0, 0, Double.MAX_VALUE);
        if (min < 0)
            this.thirdWalk(_node, -min);
    }

    private BuchheimNode firstWalk (BuchheimNode _node) {
        if (_node.getChildren().isEmpty()) {
            if (_node.getLeftMostSibling() != null) {
                _node.setX(_node.getLeftSibling().getX() + _node.getLeftSibling().getWidth() + this.widthGap);
            }
            else {
                _node.setX(this.maxWidth);
            }
        }
        else {
            BuchheimNode defaultAncestor = _node.getChildren().get(0);
            for (BuchheimNode node : _node.getChildren()) {
                this.firstWalk(node);
                defaultAncestor = this.apportion(node, defaultAncestor, this.widthGap);
            }
            this.executeShifts(_node);
            double midPoint = (_node.getFirstChild().getX() + _node.getLastChild().getX() + _node.getLastChild().getWidth()) / 2;
            _node.setX(midPoint - (_node.getWidth() / 2));
        }
        if ((_node.getX() + _node.getWidth()) > this.maxWidth) {
            this.maxWidth = _node.getX() + _node.getWidth() + this.widthGap;
        }
        return _node;
    }

    private double secondWalk (BuchheimNode _node, double _m, double _depth, double _min) {
        _node.setX(_node.getX() + _m);
        _node.setY(_depth);
        if (_node.getX() < _min)
            _min = _node.getX();
        for (BuchheimNode node : _node.getChildren()) {
            _min = this.secondWalk(node, _m + _node.getMod(), _depth + _node.getHeight() + this.heightGap, _min);
        }
        return _min;
    }

    private void thirdWalk (BuchheimNode _node, double _n) {
        _node.setX(_node.getX() + _n);
        _node.getChildren().forEach(child -> {
            this.thirdWalk(child, _n);
        });
    }

    private void executeShifts (BuchheimNode _node) {
        double shift = 0;
        double change = 0;
        BuchheimNode curNode;
        for (int i = _node.getChildren().size() - 1; i > -1; i--) {
            curNode = _node.getChildren().get(i);
            curNode.setX(curNode.getX() + shift);
            curNode.setMod(curNode.getMod() + shift);
            change += curNode.getChange();
            shift += curNode.getShift() + change;
        }
    }

    private BuchheimNode ancestor (BuchheimNode _vil, BuchheimNode _v, BuchheimNode _defaultAncestor) {
        return _v.getParent().getChildren().contains(_vil.getAncestor()) ? _vil.getAncestor() : _defaultAncestor;
    }

    private void moveSubtrees (BuchheimNode _left, BuchheimNode _right, double _shift) {
        double subtrees = _right.getNumber() - _left.getNumber();
        _right.setChange(_right.getChange() - _shift / subtrees);
        _right.setShift(_right.getShift() + _shift);
        _left.setChange(_left.getChange() + _shift / subtrees);
        _right.setX(_right.getX() + _shift);
        _right.setMod(_right.getMod() + _shift);
    }

    private BuchheimNode apportion (BuchheimNode _node, BuchheimNode _defaultAncestor, double _distance) {
        BuchheimNode leftBrother = _node.getLeftSibling();
        if (leftBrother != null) {
            BuchheimNode innerRight = _node;
            BuchheimNode outerRight = _node;
            BuchheimNode innerLeft = leftBrother;
            BuchheimNode outerLeft = _node.getLeftMostSibling();
            double shiftInnerRight = _node.getMod();
            double shiftOuterRight = _node.getMod();
            double shiftInnerLeft = innerLeft.getMod();
            double shiftOuterLeft = outerLeft.getMod();
            while (innerLeft.getNextRight()!= null && innerRight.getNextLeft() != null) {
                innerLeft = innerLeft.getNextRight();
                innerRight = innerRight.getNextLeft();
                outerLeft = outerLeft.getNextLeft();
                outerRight = outerRight.getNextRight();
                outerRight.setAncestor(_node);
                double shift = innerLeft.getX() + shiftInnerLeft + innerLeft.getWidth() - innerRight.getX() + shiftInnerRight + _distance;
                if (shift > 0) {
                    this.moveSubtrees(this.ancestor(innerLeft, _node, _defaultAncestor), _node, shift);
                    shiftInnerRight = shiftInnerRight + shift;
                    shiftOuterRight = shiftOuterRight + shift;
                }
                shiftInnerLeft += innerLeft.getMod();
                shiftInnerRight += innerRight.getMod();
                shiftOuterLeft += outerLeft.getMod();
                shiftOuterRight += outerRight.getMod();
            }
            if (innerLeft.getNextRight() != null && outerRight.getRightMostSibling() == null) {
                outerRight.setThread(innerLeft.getNextRight());
                outerRight.setMod(outerRight.getMod() + (shiftInnerLeft - shiftOuterRight));
            }
            else {
                if (innerRight.getNextLeft() != null && outerLeft.getNextLeft() == null) {
                    outerLeft.setThread(innerRight.getNextLeft());
                    outerLeft.setMod(outerLeft.getMod() + (shiftInnerRight - shiftOuterLeft));
                }
                _defaultAncestor = _node;
            }
        }
        return _defaultAncestor;
    }

}