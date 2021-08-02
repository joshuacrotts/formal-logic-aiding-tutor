package com.flat.view.main.panes.center.children.practice.listener;

import com.flat.controller.Controller;
import com.flat.models.algorithms.bus.events.practice.wfftree.UpdatePracticePane;
import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.practice.boundvariabledetector.BoundVariableDetectorPractice;
import com.flat.view.main.panes.center.children.practice.PracticePane;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.practice.closedsentencedeterminer.ClosedSentenceDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.freevariabledetector.FreeVariableDetectorPractice;
import com.flat.view.main.panes.center.children.practice.groundsentencedeterminer.GroundSentenceDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.listener.events.PracticeResult;
import com.flat.view.main.panes.center.children.practice.logicalcontingencydeterminer.LogicalContingencyDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicalfalsehooddeterminer.LogicalFalseHoodDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicallyconsistentdeterminer.LogicallyConsistentDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicallycontradictorydeterminer.LogicallyContradictoryDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicallycontrarydeterminer.LogicallyContraryDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicallyequivalentdeterminer.LogicallyEquivalentDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicallyimplieddeterminer.LogicallyImpliedDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.logicaltautologydeterminer.LogicalTautologyDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.MainOperatorDetectorPractice;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.NaturalDeductionPractice;
import com.flat.view.main.panes.center.children.practice.opensentencedeterminer.OpenSentenceDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.semanticentailmentdeterminer.SemanticEntailmentDeterminerPractice;
import com.flat.view.main.panes.center.children.practice.vacuousquantifierdetector.VacuousQuantiferDetectorPractice;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.buttons.events.PracticeSubmitTruthButtonPressed;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePaneListener implements EventListener, DataListener {
    private PracticePane practicePane;
    private Practice selectedPractice = null;
    private NaturalDeductionPractice naturalDeductionPractice = new NaturalDeductionPractice();

    public PracticePaneListener (PracticePane _practicePane) {
        this.practicePane = _practicePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case UPDATE_PRACTICE_PANE:
                this.setPracticePane((UpdatePracticePane)_event);
                break;
            case PRACTICE_SUBMIT_BUTTON_PRESSED:
                if (this.selectedPractice != null)
                    Controller.DATA_BUS.throwUpdate(new PracticeResult(this.selectedPractice.getResult()));
                break;
            case PRACTICE_SUBMIT_TRUTH_BUTTON_PRESSED:
                if (this.selectedPractice != null) {
                    this.selectedPractice.setUserAnswer(((PracticeSubmitTruthButtonPressed)_event).isTruth());
                    Controller.DATA_BUS.throwUpdate(new PracticeResult(this.selectedPractice.getResult()));
                    break;
                }
            case CLEAR_LOGIC_VISUALS:
                this.practicePane.getChildren().clear();
        }
    }

    private void setPracticePane (UpdatePracticePane _updatePane) {
        switch (_updatePane.getAlgorithmType()) {
            case MAIN_OPERATOR_DETECTOR:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new MainOperatorDetectorPractice(_updatePane.getWffTree()));
                break;
            case FREE_VARIABLE_DETECTOR:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new FreeVariableDetectorPractice(_updatePane.getWffTree()));
                break;
            case BOUND_VARIABLE_DETECTOR:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new BoundVariableDetectorPractice(_updatePane.getWffTree()));
                break;
            case VACUOUS_QUANTIFIER_DETECTOR:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new VacuousQuantiferDetectorPractice(_updatePane.getWffTree()));
                break;
            case OPEN_SENTENCE_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new OpenSentenceDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case CLOSED_SENTENCE_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new ClosedSentenceDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case GROUND_SENTENCE_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new GroundSentenceDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICAL_TAUTOLOGY_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicalTautologyDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICAL_FALSEHOOD_DETERMINER:
                System.out.println(_updatePane.getAlgorithmResult());
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicalFalseHoodDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_CONTINGENT_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicalContingencyDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_EQUIVALENT_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicallyEquivalentDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_CONTRADICTORY_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicallyContradictoryDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_CONSISTENT_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicallyConsistentDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_CONTRARY_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicallyContraryDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case LOGICALLY_IMPLIED_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new LogicallyImpliedDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case SEMANTIC_ENTAILMENT_DETERMINER:
                this.practicePane.getChildren().clear();
                this.practicePane.getChildren().add(new SemanticEntailmentDeterminerPractice(_updatePane.getAlgorithmResult(), _updatePane.getWffTree()));
                break;
            case PREDICATE_NATURAL_DEDUCTION:
            case PROPOSITIONAL_NATURAL_DEDUCTION:
                this.practicePane.getChildren().clear();
                this.naturalDeductionPractice.setProofWff(_updatePane.getWffTrees());
                this.practicePane.getChildren().add(this.naturalDeductionPractice);
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