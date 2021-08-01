package com.flat.view.main.panes.center.children.algorithmvisualselection.listener;

import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.algorithmvisualselection.AlgorithmVisualSelectionPane;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionPaneListener implements EventListener, DataListener {
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
                this.selectionPane.getPracticeButton().setDisable(true);
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
            case UPDATE_PRACTICE_PANE:
                this.selectionPane.getPracticeButton().setDisable(false);
                break;
        }
    }

    @Override
    public void handleUpdate(Update _update) {
        switch (_update.getType()) {
            case PRACTICE_MODE_TOGGLE:
                if (!((PracticeModeToggle)_update).isPractice())
                    this.selectionPane.getPracticeButton().setDisable(true);
                break;
        }
    }

}