package com.flat.view.main.panes.center.children.solver.trees.parsetree.treelayout;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.attributes.TreeNodeText;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeNode extends FxTreeNode {

    public ParseTreeNode(WffTree _wffTree) {
        super(_wffTree.isHighlighted(), 50, 50);
        super.getChildren().add(new TreeNodeText(_wffTree.getSymbol()));
        int counter = 1;
        ParseTreeNode curNode;
        for (WffTree wffTree : _wffTree.getChildren()) {
            curNode = new ParseTreeNode(wffTree);
            curNode.setTreeParent(this);
            curNode.setNumber(counter);
            this.getTreeChildren().add(curNode);
            counter++;
        }
        super.initializeLines();
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getStyleClass().add("parseTreeNode");
    }

}