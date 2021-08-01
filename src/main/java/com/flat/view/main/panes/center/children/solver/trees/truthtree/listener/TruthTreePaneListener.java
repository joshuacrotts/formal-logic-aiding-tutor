package com.flat.view.main.panes.center.children.solver.trees.truthtree.listener;

import com.flat.models.algorithms.bus.events.solver.UpdateTruthTree;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.view.main.panes.center.children.solver.trees.base.treelayout.listener.TreePaneListener;
import com.flat.view.main.panes.center.children.solver.trees.truthtree.TruthTreePane;
import com.flat.view.main.panes.center.children.solver.trees.truthtree.treelayout.TruthTreeNode;

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
                super.setTreeNode(new TruthTreeNode(((UpdateTruthTree)_event).getTruthTree()));
                break;
            case CLEAR_LOGIC_VISUALS:
                this.truthTreePane.getChildren().clear();
                break;
        }
    }

}