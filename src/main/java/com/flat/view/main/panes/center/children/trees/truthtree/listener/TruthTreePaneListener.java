package com.flat.view.main.panes.center.children.trees.truthtree.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.bus.events.UpdateTruthTree;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.view.main.panes.center.children.trees.base.treelayout.listener.TreePaneListener;
import com.flat.view.main.panes.center.children.trees.truthtree.TruthTreePane;
import com.flat.view.main.panes.center.children.trees.truthtree.treelayout.TruthTreeNode;

/**
 *
 * @author christopherbrantley
 */
public class TruthTreePaneListener extends TreePaneListener {
    private TruthTreePane truthTreePane;

    public TruthTreePaneListener (TruthTreePane _truthTreePane) {
        super(_truthTreePane);
        this.truthTreePane = _truthTreePane;
    }

    @Override
    public void catchEvent (Event _event) {
        switch (_event.getType()) {
            case UPDATE_TRUTH_TREE:
                TruthTreeNode truthNode = new TruthTreeNode(((UpdateTruthTree)_event).getTruthTree());
                Controller.TREE_LAYOUT.execute(truthNode);
                this.addNodes(truthNode);
                this.addLines(truthNode);
                break;
            case CLEAR_LOGIC_VISUALS:
                this.truthTreePane.getChildren().clear();
                break;
        }
    }

}