package com.flat.models.algorithms;

import com.flat.controller.Controller;
import com.flat.models.algorithms.attributes.LogicReturn;
import com.flat.models.algorithms.bus.events.practice.UpdateMainOperatorDetectorPractice;
import com.flat.models.algorithms.bus.events.solver.ClearLogicVisuals;
import com.flat.models.algorithms.bus.events.solver.FormulaGenerated;
import com.flat.models.algorithms.bus.events.solver.UpdateNaturalDeduction;
import com.flat.models.algorithms.bus.events.solver.UpdateParseTree;
import com.flat.models.algorithms.bus.events.solver.UpdateTruth;
import com.flat.models.algorithms.bus.events.solver.UpdateTruthTable;
import com.flat.models.algorithms.bus.events.solver.UpdateTruthTree;
import com.flat.models.algorithms.bus.updates.ApplicableAlgorithmsUpdate;
import com.flat.models.data.algorithms.Algorithms;
import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import static com.flat.models.data.algorithms.base.enums.AlgorithmType.CLOSED_SENTENCE_DETERMINER;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithmAdapter extends ApplyAlgorithm implements DataListener {
    private boolean practiceMode = false;

    public ApplyAlgorithmAdapter (Algorithms _algorithms) {
        super(_algorithms);
        Controller.DATA_BUS.throwUpdate(new ApplicableAlgorithmsUpdate(super.getApplicableAlgorithms()));
        Controller.DATA_BUS.addListener(this);
    }

    @Override
    public LogicReturn apply(Algorithm _algorithm) {
        LogicReturn logicReturn = super.apply(_algorithm);
        Controller.EVENT_BUS.throwEvent(new ClearLogicVisuals());
        switch (_algorithm.getType()) {
            case CLOSED_SENTENCE_DETERMINER:
            case CLOSED_TREE_DETERMINER:
            case GROUND_SENTENCE_DETERMINER:
            case LOGICALLY_CONTINGENT_DETERMINER:
            case OPEN_TREE_DETERMINER:
            case OPEN_SENTENCE_DETERMINER:
                Controller.EVENT_BUS.throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                Controller.EVENT_BUS.throwEvent(new UpdateTruth(logicReturn.getTruthValue()));
                break;
            case BOUND_VARIABLE_DETECTOR:
            case FREE_VARIABLE_DETECTOR:
            case MAIN_OPERATOR_DETECTOR:
            case Vacuous_QUANTIFIER_DETECTOR:
                Controller.EVENT_BUS.throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                break;
            case PREDICATE_TRUTH_TREE_GENERATOR:
            case PROPOSITIONAL_TRUTH_TREE_GENERATOR:
                Controller.EVENT_BUS.throwEvent(new UpdateTruthTree(logicReturn.getTruthTree()));
                Controller.EVENT_BUS.throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                break;
            case ARGUMENT_TRUTH_TREE_VALIDATOR:
            case LOGICAL_FALSEHOOD_DETERMINER:
            case LOGICAL_TAUTOLOGY_DETERMINER:
            case LOGICALLY_CONSISTENT_DETERMINER:
            case LOGICALLY_CONTRADICTORY_DETERMINER:
            case LOGICALLY_CONTRARY_DETERMINER:
            case LOGICALLY_EQUIVALENT_DETERMINER:
            case LOGICALLY_IMPLIED_DETERMINER:
            case SEMANTIC_ENTAILMENT_DETERMINER:
                logicReturn.getWffTree().setFlags(logicReturn.getWffTree().getFlags());
                Controller.EVENT_BUS.throwEvent(new UpdateTruthTree(logicReturn.getTruthTree()));
                Controller.EVENT_BUS.throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                Controller.EVENT_BUS.throwEvent(new UpdateTruth(logicReturn.getTruthValue()));
                break;
            case TRUTH_TABLE_GENERATOR:
                Controller.EVENT_BUS.throwEvent(new UpdateTruthTable(logicReturn.getWffTree()));
                break;
            case RANDOM_PREDICATE_FORMULA:
            case RANDOM_PROPOSITIONAL_FORMULA:
                Controller.EVENT_BUS.throwEvent(new FormulaGenerated(logicReturn.getFormula()));
                break;
            case PROPOSITIONAL_NATURAL_DEDUCTION:
            case PREDICATE_NATURAL_DEDUCTION:
                if (logicReturn.getTruthValue())
                    Controller.EVENT_BUS.throwEvent(new UpdateNaturalDeduction(logicReturn.getNdWffTree()));
                else
                    Controller.displayNaturalDeductionPopup();
                Controller.EVENT_BUS.throwEvent(new UpdateTruth(logicReturn.getTruthValue()));
                break;
        }
        if (this.practiceMode)
            this.throwPracticeUpdates(_algorithm.getType(), logicReturn);
        return logicReturn;
    }

    private void throwPracticeUpdates (AlgorithmType _algorithmType, LogicReturn _logicReturn) {
        switch (_algorithmType) {
            case MAIN_OPERATOR_DETECTOR:
                Controller.EVENT_BUS.throwEvent(new UpdateMainOperatorDetectorPractice(_logicReturn.getWffTree()));
                break;
        }
    }

    @Override
    public void setWffTree(ArrayList<WffTree> wffTree) {
        super.setWffTree(wffTree);
        Controller.DATA_BUS.throwUpdate(new ApplicableAlgorithmsUpdate(super.getApplicableAlgorithms()));
    }

    @Override
    public void handleUpdate(Update _update) {
        switch (_update.getType()) {
            case PRACTICE_MODE_TOGGLE:
                this.practiceMode = ((PracticeModeToggle)_update).isPractice();
                break;
        }
    }

}