package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.TreeNode;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
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
                Controller.getBuccheimTree().execute(treeNode);
                this.layoutTree(treeNode);
                break;
            case CLEAR_LOGIC_VISUALS:
                this.parseTreePane.getChildren().clear();
        }
    }

    public void layoutTree (TreeNode _treeNode) {
        _treeNode.getChildren().forEach((treeNode) -> {
            this.layoutTree(treeNode);
        });
        Text text = new Text(_treeNode.getText());
        this.parseTreePane.getChildren().add(text);
        text.setLayoutX(_treeNode.getX());
        text.setLayoutY(_treeNode.getY());
        text.setX(_treeNode.getX() + _treeNode.getWidth() / 2);
        text.setY(_treeNode.getY() + _treeNode.getHeight() / 2);
    }

}