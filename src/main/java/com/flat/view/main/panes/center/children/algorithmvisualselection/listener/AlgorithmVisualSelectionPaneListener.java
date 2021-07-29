package com.flat.view.main.panes.center.children.algorithmvisualselection.listener;

import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.algorithmvisualselection.AlgorithmVisualSelectionPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionPaneListener implements EventListener {
    private AlgorithmVisualSelectionPane selectionPane;

    public AlgorithmVisualSelectionPaneListener (AlgorithmVisualSelectionPane _selectionPane) {
        this.selectionPane = _selectionPane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.selectionPane.getTruthTreeButton().setDisable(true);
                this.selectionPane.getParseTreeButton().setDisable(true);
                this.selectionPane.getTruthTableButton().setDisable(true);
                this.selectionPane.getNaturalDeductionButton().setDisable(true);
                break;
            case UPDATE_PARSE_TREE:
                this.selectionPane.getParseTreeButton().setDisable(false);
                break;
            case UPDATE_TRUTH_TREE:
                this.selectionPane.getTruthTreeButton().setDisable(false);
                break;
            case UPDATE_TRUTH_TABLE:
                this.selectionPane.getTruthTableButton().setDisable(false);
                break;
            case UPDATE_NATURAL_DEDUCTION:
                this.selectionPane.getNaturalDeductionButton().setDisable(false);
                break;
        }
    }

}
