package com.flat.view.main.panes.center.children.algorithmselection.listener;

import com.flat.controller.Controller;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.algorithmselection.AlgorithmSelectionPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmSelectionPaneListener implements Listener {
    private AlgorithmSelectionPane algorithmSelectionPane;

    public AlgorithmSelectionPaneListener (AlgorithmSelectionPane _algorithmSelectionPane) {
        this.algorithmSelectionPane = _algorithmSelectionPane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case FORMULA_APPLY_BUTTON_PRESSED:
                if (algorithmSelectionPane.getSelectedAlgorithm() != null) {
                    Controller.applyFormula(this.algorithmSelectionPane.getSelectedAlgorithm());
                    this.algorithmSelectionPane.setSelectedAlgorithm(null);
                }
        }
    }

}