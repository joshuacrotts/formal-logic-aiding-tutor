package com.flat.view.main.panes.center.children.practice.base.parsetree.nodes;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.FxTreeNode;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.nodes.attributes.TreeNodeText;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeParseTreeNode extends FxTreeNode {
    private WffTree wffTree;
    private boolean dragged = false;

    public PracticeParseTreeNode(WffTree _wffTree) {
        super(false, 50, 50);
        this.wffTree = _wffTree;
        super.getChildren().add(new TreeNodeText(_wffTree.getSymbol()));
        int counter = 1;
        PracticeParseTreeNode curNode;
        for (WffTree child : _wffTree.getChildren()) {
            curNode = new PracticeParseTreeNode(child);
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
        this.setHighlightOnClick();
    }

    private void setHighlightOnClick () {
        super.setOnMouseClicked(event -> {
            if (!super.isDragged())
                super.toggleHighlightFx();
        });
    }

    @Override
    protected void setOnMouseDrag() {
    }


    // Getters for object's attributes.
    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

}