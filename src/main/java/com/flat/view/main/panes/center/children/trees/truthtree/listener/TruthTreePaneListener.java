package com.flat.view.main.panes.center.children.trees.truthtree.listener;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.trees.truthtree.TruthTreePane;

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
                break;
            case CLEAR_LOGIC_VISUALS:
                this.truthTreePane.getChildren().clear();
        }
    }

}