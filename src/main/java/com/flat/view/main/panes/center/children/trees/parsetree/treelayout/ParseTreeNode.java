package com.flat.view.main.panes.center.children.trees.parsetree.treelayout;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.trees.base.treelayout.FxTreeNode;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeNode extends FxTreeNode {

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
    }

}