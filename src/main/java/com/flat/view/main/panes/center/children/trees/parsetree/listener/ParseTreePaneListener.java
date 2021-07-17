package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.treelayout.FxTreeNode;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeNode;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
import com.flat.view.main.panes.center.children.trees.parsetree.treelayout.ParseTreeNode;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Line;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreePaneListener implements Listener {
    private ParseTreePane parseTreePane;

    public ParseTreePaneListener (ParseTreePane _parseTreePane) {
        this.parseTreePane = _parseTreePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case UPDATE_PARSE_TREE:
                ParseTreeNode parseNode = new ParseTreeNode(((UpdateParseTree)_event).getWffTree().getChild(0));
                Controller.getTREE_LAYOUT().execute(parseNode);
                this.drawTree(parseNode);
                this.drawLines(parseNode);
                break;
            case CLEAR_LOGIC_VISUALS:
                this.parseTreePane.getChildren().clear();
        }
    }

    public void drawTree (TreeNode _treeNode) {
        _treeNode.getChildren().forEach((treeNode) -> {
            this.drawTree(treeNode);
        });
        this.parseTreePane.getChildren().add(_treeNode);
    }

    public void drawLines (FxTreeNode _fxNode) {
        for (TreeNode child : _fxNode.getChildren()) {
            FxTreeNode fxChild = (FxTreeNode)child;
            Line line = new Line();
            line.startXProperty().bind(_fxNode.getCenterX());
            line.startYProperty().bind(_fxNode.getBottomCenterY());
            line.endXProperty().bind(fxChild.getCenterX());
            line.endYProperty().bind(fxChild.getTopCenterY());
            this.drawLines(fxChild);
            this.parseTreePane.getChildren().add(line);
        }
    }

}