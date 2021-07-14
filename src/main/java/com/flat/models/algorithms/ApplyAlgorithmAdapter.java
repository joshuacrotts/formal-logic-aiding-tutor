package com.flat.models.algorithms;

import com.flat.controller.Controller;
import com.flat.models.algorithms.attributes.LogicReturn;
import com.flat.models.algorithms.events.ClearLogicVisuals;
import com.flat.models.algorithms.events.FormulaGenerated;
import com.flat.models.algorithms.events.UpdateParseTree;
import com.flat.models.algorithms.events.UpdateTruthTable;
import com.flat.models.algorithms.events.UpdateTruthTree;
import com.flat.models.json.algorithm.JsonAlgorithm;
import com.flat.models.json.algorithm.JsonAlgorithms;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithmAdapter extends ApplyAlgorithm {

    public ApplyAlgorithmAdapter (JsonAlgorithms _algorithms) {
        super(_algorithms);
    }

    @Override
    public LogicReturn apply(JsonAlgorithm _jsonAlgorithm) {
        LogicReturn logicReturn = super.apply(_jsonAlgorithm);
        Controller.getEVENT_BUS().throwEvent(new ClearLogicVisuals());
        switch (_jsonAlgorithm.getAlgorithmType()) {
            case CLOSED_SENTENCE_DETERMINER:
            case CLOSED_TREE_DETERMINER:
            case GROUND_SENTENCE_DETERMINER:
            case LOGICALLY_CONTINGENT_DETERMINER:
            case OPEN_TREE_DETERMINER:
            case OPEN_SENTENCE_DETERMINER:
                Controller.getEVENT_BUS().throwEvent(new UpdateTruthTree(logicReturn.getTruthTree()));
                Controller.getEVENT_BUS().throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                break;
            case TRUTH_TABLE_GENERATOR:
                Controller.getEVENT_BUS().throwEvent(new UpdateTruthTable(logicReturn.getWffTree()));
                break;
            case BOUND_VARIABLE_DETECTOR:
            case FREE_VARIABLE_DETECTOR:
            case MAIN_OPERATOR_DETECTOR:
                Controller.getEVENT_BUS().throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                break;
            case PREDICATE_TRUTH_TREE_GENERATOR:
            case PROPOSITIONAL_TRUTH_TREE_GENERATOR:
                Controller.getEVENT_BUS().throwEvent(new UpdateTruthTree(logicReturn.getTruthTree()));
                Controller.getEVENT_BUS().throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
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
                Controller.getEVENT_BUS().throwEvent(new UpdateTruthTree(logicReturn.getTruthTree()));
                Controller.getEVENT_BUS().throwEvent(new UpdateParseTree(logicReturn.getWffTree()));
                break;
            case RANDOM_PREDICATE_FORMULA:
            case RANDOM_PROPOSITIONAL_FORMULA:
                Controller.getEVENT_BUS().throwEvent(new FormulaGenerated(logicReturn.getFormula()));
                break;
        }
        return logicReturn;
    }

}