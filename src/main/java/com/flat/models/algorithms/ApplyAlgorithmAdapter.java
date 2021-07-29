package com.flat.models.algorithms;

import com.flat.controller.Controller;
import com.flat.models.algorithms.attributes.LogicReturn;
import com.flat.models.algorithms.bus.events.ClearLogicVisuals;
import com.flat.models.algorithms.bus.events.FormulaGenerated;
import com.flat.models.algorithms.bus.events.UpdateNaturalDeduction;
import com.flat.models.algorithms.bus.events.UpdateParseTree;
import com.flat.models.algorithms.bus.events.UpdateTruth;
import com.flat.models.algorithms.bus.events.UpdateTruthTable;
import com.flat.models.algorithms.bus.events.UpdateTruthTree;
import com.flat.models.algorithms.bus.updates.ApplicableAlgorithmsUpdate;
import com.flat.models.data.algorithms.Algorithms;
import com.flat.models.data.algorithms.base.Algorithm;
import static com.flat.models.data.algorithms.base.enums.AlgorithmType.CLOSED_SENTENCE_DETERMINER;
import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithmAdapter extends ApplyAlgorithm {

    public ApplyAlgorithmAdapter (Algorithms _algorithms) {
        super(_algorithms);
        Controller.DATA_BUS.throwUpdate(new ApplicableAlgorithmsUpdate(super.getApplicableAlgorithms()));
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
            case VACCUOUS_QUANTIFIER_DETECTOR:
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
                if (logicReturn.getNdWffTree() != null)
                    Controller.EVENT_BUS.throwEvent(new UpdateNaturalDeduction(logicReturn.getNdWffTree()));
                //else
                break;
        }
        return logicReturn;
    }

    @Override
    public void setWffTree(ArrayList<WffTree> wffTree) {
        super.setWffTree(wffTree);
        Controller.DATA_BUS.throwUpdate(new ApplicableAlgorithmsUpdate(super.getApplicableAlgorithms()));
    }

}