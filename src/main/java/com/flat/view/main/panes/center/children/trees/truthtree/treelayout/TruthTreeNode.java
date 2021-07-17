package com.flat.view.main.panes.center.children.trees.truthtree.treelayout;

import com.flat.algorithms.models.TruthTree;
import com.flat.view.main.panes.center.children.trees.base.treelayout.FxTreeNode;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreeNode extends FxTreeNode {

    public TruthTreeNode (TruthTree _truthTree) {
        super();
        super.setText(_truthTree.getWff().getStringRep());
        super.setTextAlignment(TextAlignment.CENTER);
        if (_truthTree.getLeft() == null && _truthTree.getRight() == null) {
            this.appendClosedProperty(_truthTree);
        }
        else {
            TruthTree curTree = _truthTree;
            while (curTree.getLeft() != null && curTree.getRight() == null) {
                this.appendText("\n" + curTree.getLeft().getWff().getStringRep());
                curTree = curTree.getLeft();
            }
            if (curTree.getLeft() != null && curTree.getRight() != null && !curTree.equals(_truthTree)) {
                this.addChild(curTree.getLeft(), 1);
                this.addChild(curTree.getRight(), 2);
            } else if (!curTree.equals(_truthTree)) {
                this.appendClosedProperty(curTree);
            }
            if (_truthTree.getLeft() != null && _truthTree.getRight() != null) {
                this.addChild(_truthTree.getLeft(), 1);
                this.addChild(_truthTree.getRight(), 2);
            }
        }
        super.initializeLines();
    }

    private void addChild (TruthTree _truthTree, int _number) {
        TruthTreeNode _truthNode = new TruthTreeNode(_truthTree);
        _truthNode.setTreeNodeParent(this);
        _truthNode.setNumber(_number);
        this.getChildren().add(_truthNode);
    }

    private void appendText (String _text) {
        super.setText(super.getText() + _text);
    }

    private void appendClosedProperty (TruthTree _truthTree) {
        this.appendText((_truthTree.isClosed()) ? "\nClosed" : "\nOpen");
    }

}