package com.flat.view.main.panes.center.children.practice.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.bus.events.practice.wfftree.EventBoundVariableDetectorPractice;
import com.flat.models.algorithms.bus.events.practice.wfftree.EventFreeVariableDetectorPractice;
import com.flat.models.algorithms.bus.events.practice.wfftree.EventMainOperatorDetectorPractice;
import com.flat.models.algorithms.bus.events.practice.wfftree.EventVacuousQuantifierDetectorPractice;
import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.practice.boundvariabledetector.BoundVariableDetectorPractice;
import com.flat.view.main.panes.center.children.practice.PracticePane;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.practice.freevariabledetector.FreeVariableDetectorPractice;
import com.flat.view.main.panes.center.children.practice.listener.events.PracticeResult;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.MainOperatorDetectorPractice;
import com.flat.view.main.panes.center.children.practice.vacuousquantifierdetector.VacuousQuantiferDetectorPractice;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePaneListener implements EventListener, DataListener {
    private PracticePane practicePane;
    private Practice selectedPractice = null;

    public PracticePaneListener (PracticePane _practicePane) {
        this.practicePane = _practicePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case EVENT_MAIN_OPERATOR_DETECTOR_PRACTICE:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new MainOperatorDetectorPractice(((EventMainOperatorDetectorPractice)_event).getWffTree()));
                break;
            case EVENT_FREE_VARIABLE_DETECTOR_PRACTICE:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new FreeVariableDetectorPractice(((EventFreeVariableDetectorPractice)_event).getWffTree()));
                break;
            case EVENT_BOUND_VARIABLE_DETECTOR_PRACTICE:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new BoundVariableDetectorPractice(((EventBoundVariableDetectorPractice)_event).getWffTree()));
                break;
            case EVENT_VACUOUS_QUANTIFIER_DETECTOR_PRACTICE:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new VacuousQuantiferDetectorPractice(((EventVacuousQuantifierDetectorPractice)_event).getWffTree()));
                break;
            case PRACTICE_SUBMIT_BUTTON_PRESSED:
                if (this.selectedPractice != null)
                    Controller.DATA_BUS.throwUpdate(new PracticeResult(this.selectedPractice.getResult()));
                break;
        }
    }

    @Override
    public void handleUpdate(Update _update) {
        switch (_update.getType()) {
            case PRACTICE_PANE_UPDATE:
                this.selectedPractice = ((PracticePaneUpdate)_update).getPracticePane();
                break;
            case PRACTICE_MODE_TOGGLE:
                if (!((PracticeModeToggle)_update).isPractice())
                    this.practicePane.getChildren().clear();
                break;
        }
    }

}