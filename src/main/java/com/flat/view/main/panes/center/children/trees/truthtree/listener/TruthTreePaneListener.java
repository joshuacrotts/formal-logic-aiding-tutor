package com.flat.view.main.panes.center.children.trees.truthtree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateTruthTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeNode;
import com.flat.view.main.panes.center.children.trees.truthtree.TruthTreePane;
import com.flat.view.main.panes.center.children.trees.truthtree.treelayout.TruthTreeNode;
import javafx.scene.shape.Line;

/**
 *
 * @author christopherbrantley
 */
public class TruthTreePaneListener implements Listener {
    private TruthTreePane truthTreePane;

    public TruthTreePaneListener (TruthTreePane _truthTreePane) {
        this.truthTreePane = _truthTreePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case UPDATE_TRUTH_TREE:
                TruthTreeNode truthNode = new TruthTreeNode(((UpdateTruthTree)_event).getTruthTree());
                Controller.getTREE_LAYOUT().execute(truthNode);
                this.drawTree(truthNode);
                this.drawLines(truthNode);
                break;
            case CLEAR_LOGIC_VISUALS:
                this.truthTreePane.getChildren().clear();
        }
    }
    public void drawTree (TreeNode _treeNode) {
        _treeNode.getChildren().forEach((treeNode) -> {
            this.drawTree(treeNode);
        });
        this.truthTreePane.getChildren().add(_treeNode);
    }

    public void drawLines (TreeNode _treeNode) {
        for (TreeNode child : _treeNode.getChildren()) {
            this.drawLines(child);
            Line line = new Line();
            _treeNode.layoutBoundsProperty().addListener(listener -> {
                line.setStartX((_treeNode.getLayoutBounds().getMinX() + _treeNode.getLayoutBounds().getMaxX()) / 2);
                line.setEndX((child.getLayoutBounds().getMinX() + child.getLayoutBounds().getMaxX()) / 2);
                line.setStartY(_treeNode.getLayoutBounds().getMaxY());
                line.setEndY(child.getLayoutBounds().getMinY());
            });
            line.setStartX((_treeNode.getLayoutBounds().getMinX() + _treeNode.getLayoutBounds().getMaxX()) / 2);
            line.setEndX((child.getLayoutBounds().getMinX() + child.getLayoutBounds().getMaxX()) / 2);
            line.setStartY(_treeNode.getLayoutBounds().getMaxY());
            line.setEndY(child.getLayoutBounds().getMinY());
            this.truthTreePane.getChildren().add(line);
        }
    }

}