package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.base.BuchheimTree;
import com.flat.view.main.panes.center.children.trees.base.TreeNode;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;

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
        _treeNode.getTreeNodeChildren().forEach((treeNode) -> {
            this.layoutTree(treeNode);
        });
        this.parseTreePane.getChildren().add(_treeNode);
        _treeNode.setX(_treeNode.getX() + (this.parseTreePane.getWidth() / 2));
        _treeNode.setY(_treeNode.getY() + (this.parseTreePane.getHeight() / 2));
    }

}