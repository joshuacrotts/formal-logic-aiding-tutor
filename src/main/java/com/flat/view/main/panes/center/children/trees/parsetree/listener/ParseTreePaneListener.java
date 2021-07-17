package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeNode;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
import com.flat.view.main.panes.center.children.trees.parsetree.treelayout.ParseTreeNode;
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
            this.parseTreePane.getChildren().add(line);
        }
    }

}