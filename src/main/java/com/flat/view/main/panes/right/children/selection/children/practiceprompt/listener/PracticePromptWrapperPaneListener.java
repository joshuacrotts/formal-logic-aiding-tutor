package com.flat.view.main.panes.right.children.selection.children.practiceprompt.listener;

import com.flat.models.algorithms.bus.events.practice.wfftree.UpdatePracticePane;
import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.PracticeWrapperPane;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.boundvariabledetector.BoundVariableDetectorPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.closedsentencedeterminer.ClosedSentenceDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.freevariabledetector.FreeVariableDetectorPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.groundsentencedeterminer.GroundSentenceDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicalcontingencydeterminer.LogicalContingencyDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicalfalsehooddeterminer.LogicalFalsehoodDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyconsistentdeterminer.LogicallyConsistentDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallycontradictorydeterminer.LogicallyContradictoryDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallycontrarydeterminer.LogicallyContraryDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyequivalentdeterminer.LogicallyEquivalentDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyimplieddeterminer.LogicallyImpliedDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicaltautologydeterminer.LogicalTautologyDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.mainoperatordetector.MainOperatorDetectorPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.naturaldeduction.NaturalDeductionPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.opensentencedeterminer.OpenSentenceDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.semanticentailmentdeterminer.SemanticEntailmentDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.treedeterminer.TreeDeterminerPrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.truthtable.TruthTablePrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.vacuousquantifierdetector.VacuousQuantifierDetectorPrompt;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePromptWrapperPaneListener implements DataListener, EventListener {
    private PracticeWrapperPane wrapperPane;
    private boolean practiceToggle = false;

    public PracticePromptWrapperPaneListener (PracticeWrapperPane _wrapperPane) {
        this.wrapperPane = _wrapperPane;
    }

    @Override
    public void handleUpdate(Update _update) {
        switch(_update.getType()) {
            case PRACTICE_MODE_TOGGLE:
                this.setPracticeToggle(((PracticeModeToggle)_update).isPractice());
                break;
        }
    }

    @Override
    public void catchEvent(Event _event) {
        switch(_event.getType()) {
            case UPDATE_PRACTICE_PANE:
                this.handleUpdatePracticePaneEvent(((UpdatePracticePane)_event));
                break;
            case CLEAR_LOGIC_VISUALS:
                this.wrapperPane.setContent(null);
                break;
        }
    }

    private void handleUpdatePracticePaneEvent (UpdatePracticePane _update) {
        switch (_update.getAlgorithmType()) {
            case MAIN_OPERATOR_DETECTOR:
                this.wrapperPane.setContent(new MainOperatorDetectorPrompt());
                break;
            case FREE_VARIABLE_DETECTOR:
                this.wrapperPane.setContent(new FreeVariableDetectorPrompt());
                break;
            case BOUND_VARIABLE_DETECTOR:
                this.wrapperPane.setContent(new BoundVariableDetectorPrompt());
                break;
            case VACUOUS_QUANTIFIER_DETECTOR:
                this.wrapperPane.setContent(new VacuousQuantifierDetectorPrompt());
                break;
            case OPEN_SENTENCE_DETERMINER:
                this.wrapperPane.setContent(new OpenSentenceDeterminerPrompt());
                break;
            case CLOSED_SENTENCE_DETERMINER:
                this.wrapperPane.setContent(new ClosedSentenceDeterminerPrompt());
                break;
            case GROUND_SENTENCE_DETERMINER:
                this.wrapperPane.setContent(new GroundSentenceDeterminerPrompt());
                break;
            case LOGICAL_TAUTOLOGY_DETERMINER:
                this.wrapperPane.setContent(new LogicalTautologyDeterminerPrompt());
                break;
            case LOGICAL_FALSEHOOD_DETERMINER:
                this.wrapperPane.setContent(new LogicalFalsehoodDeterminerPrompt());
                break;
            case LOGICALLY_CONTINGENT_DETERMINER:
                this.wrapperPane.setContent(new LogicalContingencyDeterminerPrompt());
                break;
            case LOGICALLY_EQUIVALENT_DETERMINER:
                this.wrapperPane.setContent(new LogicallyEquivalentDeterminerPrompt());
                break;
            case LOGICALLY_CONTRADICTORY_DETERMINER:
                this.wrapperPane.setContent(new LogicallyContradictoryDeterminerPrompt());
                break;
            case LOGICALLY_CONSISTENT_DETERMINER:
                this.wrapperPane.setContent(new LogicallyConsistentDeterminerPrompt());
                break;
            case LOGICALLY_CONTRARY_DETERMINER:
                this.wrapperPane.setContent(new LogicallyContraryDeterminerPrompt());
                break;
            case LOGICALLY_IMPLIED_DETERMINER:
                this.wrapperPane.setContent(new LogicallyImpliedDeterminerPrompt());
                break;
            case SEMANTIC_ENTAILMENT_DETERMINER:
                this.wrapperPane.setContent(new SemanticEntailmentDeterminerPrompt());
                break;
            case PREDICATE_NATURAL_DEDUCTION:
            case PROPOSITIONAL_NATURAL_DEDUCTION:
                this.wrapperPane.setContent(new NaturalDeductionPrompt());
                break;
            case TRUTH_TABLE_GENERATOR:
                this.wrapperPane.setContent(new TruthTablePrompt());
                break;
            case OPEN_TREE_DETERMINER:
            case CLOSED_TREE_DETERMINER:
                this.wrapperPane.setContent(new TreeDeterminerPrompt());
                break;
        }
    }

    private void setPracticeToggle (boolean _boolean) {
        this.practiceToggle = _boolean;
        if (!this.practiceToggle)
            this.wrapperPane.setContent(null);
    }

}