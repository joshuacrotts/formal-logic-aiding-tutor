package com.flat.view.main.panes.center.children.trees.parsetree.listener;

import com.flat.models.algorithms.bus.events.UpdateParseTree;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.view.main.panes.center.children.trees.base.treelayout.listener.TreePaneListener;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
import com.flat.view.main.panes.center.children.trees.parsetree.treelayout.ParseTreeNode;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreePaneListener extends TreePaneListener {
    private ParseTreePane parseTreePane;

    public ParseTreePaneListener (ParseTreePane _parseTreePane) {
        super(_parseTreePane);
        this.parseTreePane = _parseTreePane;
    }

    @Override
    public void catchEvent (Event _event) {
        switch (_event.getType()) {
            case UPDATE_PARSE_TREE:
                this.setTreeNode(new ParseTreeNode(((UpdateParseTree)_event).getWffTree().getChild(0)));
                break;
            case CLEAR_LOGIC_VISUALS:
                this.parseTreePane.getChildren().clear();
                break;
        }
    }

}