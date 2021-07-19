package com.flat.view.main.panes.center.children.algorithmvisualselection.listener;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.algorithmvisualselection.AlgorithmVisualSelectionPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionListener implements Listener {
    private AlgorithmVisualSelectionPane algorithmPane;

    public AlgorithmVisualSelectionListener (AlgorithmVisualSelectionPane _algorithmPane) {
        this.algorithmPane = _algorithmPane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case UPDATE_TRUTH:
                
        }
    }

}