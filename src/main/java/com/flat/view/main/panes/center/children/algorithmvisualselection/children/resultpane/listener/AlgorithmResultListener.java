package com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.listener;

import com.flat.models.algorithms.events.UpdateTruth;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.AlgorithmResultPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmResultListener implements Listener{
    private AlgorithmResultPane resultPane;

    public AlgorithmResultListener (AlgorithmResultPane _resultPane) {
        this.resultPane = _resultPane;
    }

    @Override
    public void catchEvent(Event _event) {
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