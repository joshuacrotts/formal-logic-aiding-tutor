package com.flat.view.main.panes.center.children.truthtable.listener;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.truthtable.TruthTablePane;

/**
 *
 * @author christopherbrantley
 */
public class TruthTablePaneListener implements Listener {
    private TruthTablePane truthTablePane;

    public TruthTablePaneListener (TruthTablePane _truthTablePane) {
        this.truthTablePane = _truthTablePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case UPDATE_TRUTH_TABLE:
                break;
            case CLEAR_LOGIC_VISUALS:
                this.truthTablePane.getChildren().clear();
        }
    }

}