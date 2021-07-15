package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.TreeLayout;
import com.flat.view.main.panes.center.children.trees.base.TreeNode;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

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
                TreeNode treeNode = new TreeNode(((UpdateParseTree)_event).getWffTree().getChild(0));
                Controller.getTREE_LAYOUT().execute(treeNode);
                this.layoutTree(treeNode, treeNode.getWidth());
                this.drawLines(treeNode, treeNode.getWidth());
                break;
            case CLEAR_LOGIC_VISUALS:
                this.parseTreePane.getChildren().clear();
        }
    }

    public void layoutTree (TreeNode _treeNode, double _offset) {
        _treeNode.getChildren().forEach((treeNode) -> {
            this.layoutTree(treeNode, _offset);
        });
        Text text = new Text(_treeNode.getText());
        VBox vbox = new VBox(text);
        this.parseTreePane.getChildren().add(vbox);
        vbox.setLayoutX(((this.parseTreePane.getWidth() - _offset) / 2) + _treeNode.getX());
        vbox.setLayoutY(((this.parseTreePane.getHeight()) / 2) + _treeNode.getY());
    }

    public void drawLines (TreeNode _treeNode, double _offset) {
        for (TreeNode child : _treeNode.getChildren()) {
            this.drawLines(child, _offset);
            Line line = new Line();
            line.setStartX(((this.parseTreePane.getWidth() - _offset) / 2) + _treeNode.getX());
            line.setStartY(((this.parseTreePane.getHeight()) / 2) + _treeNode.getY() + TreeLayout.getHeightGap());
            line.setEndX(((this.parseTreePane.getWidth() - _offset) / 2) + child.getX() /*+ (child.getWidth() / 2)*/);
            line.setEndY(((this.parseTreePane.getHeight()) / 2) + child.getY());
            this.parseTreePane.getChildren().add(line);
        }
    }

}