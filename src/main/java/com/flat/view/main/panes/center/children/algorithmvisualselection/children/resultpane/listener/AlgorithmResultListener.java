package com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.listener;

import com.flat.models.algorithms.bus.events.solver.UpdateTruth;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.AlgorithmResultPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmResultListener implements EventListener {
    private AlgorithmResultPane resultPane;

    public AlgorithmResultListener (AlgorithmResultPane _resultPane) {
        this.resultPane = _resultPane;
    }

    @Override
    public void catchEvent (Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.clearResult();
                break;
            case UPDATE_TRUTH:
                this.updateResult(((UpdateTruth)_event).isTruth());
                break;
        }
    }

    private void updateResult (boolean _truth) {
        this.resultPane.getResult().setText(String.valueOf(_truth));
    }

    private void clearResult () {
        this.resultPane.getResult().setText("");
    }

}