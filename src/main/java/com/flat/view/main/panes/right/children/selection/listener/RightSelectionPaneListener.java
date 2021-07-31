package com.flat.view.main.panes.right.children.selection.listener;

import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.right.children.selection.RightSelectionPane;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RightSelectionPaneListener implements EventListener {
    private RightSelectionPane selectionPane;
    private ScrollPane currentlySelected = null;
    public RightSelectionPaneListener (RightSelectionPane _selectionpane) {
        this.selectionPane = _selectionpane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case PRACTICE_SELECTION_BUTTON_PRESSED:
                this.removeSelection();
                this.selectionPane.getChildren().add(this.selectionPane.getPracticePane());
                this.currentlySelected = this.selectionPane.getPracticePane();
                break;
            case RULES_AXIOMS_SELECTION_BUTTON_PRESSED:
                this.removeSelection();
                this.selectionPane.getChildren().add(this.selectionPane.getRulesAxiomsPane());
                this.currentlySelected = this.selectionPane.getRulesAxiomsPane();
                break;
        }
    }

    private void removeSelection () {
        if (currentlySelected != null)
            this.selectionPane.getChildren().remove(this.currentlySelected);
    }

}