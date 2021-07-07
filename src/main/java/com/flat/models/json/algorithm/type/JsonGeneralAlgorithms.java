package com.flat.models.json.algorithm.type;

import com.flat.models.json.JsonString;
import com.flat.models.json.algorithm.JsonAlgorithm;
import com.flat.models.json.algorithm.enums.AlgorithmType;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonGeneralAlgorithms extends Translatable {
    private JsonString label = new JsonString("General Logic Algorithms");
    private JsonAlgorithm argumentTruthTreeValidator = new JsonAlgorithm("Argument Truth Tree Validator", AlgorithmType.ARGUMENT_TRUTH_TREE_VALIDATOR);
    private JsonAlgorithm closedTreeDeterminer = new JsonAlgorithm("Closed Tree Determiner", AlgorithmType.CLOSED_TREE_DETERMINER);
    private JsonAlgorithm logicalFalsehoodDeterminer = new JsonAlgorithm("Logical Falsehood Determiner", AlgorithmType.LOGICAL_FALSEHOOD_DETERMINER);
    private JsonAlgorithm logicallyConsistentDeterminer = new JsonAlgorithm("Logically Consistent Determiner", AlgorithmType.LOGICALLY_CONSISTENT_DETERMINER);
    private JsonAlgorithm logicallyContingentDeterminer = new JsonAlgorithm("Logically Contingent Determiner", AlgorithmType.LOGICALLY_CONTINGENT_DETERMINER);
    private JsonAlgorithm logicallyContradictoryDeterminer = new JsonAlgorithm("Logically Contradictory Determiner", AlgorithmType.LOGICALLY_CONTRADICTORY_DETERMINER);
    private JsonAlgorithm logicallyContraryDeterminer = new JsonAlgorithm("Logically Contrary Determiner", AlgorithmType.LOGICALLY_CONTRARY_DETERMINER);
    private JsonAlgorithm logicallyEquivalentDeterminer = new JsonAlgorithm("Logically Equivalent Determiner", AlgorithmType.LOGICALLY_EQUIVALENT_DETERMINER);
    private JsonAlgorithm logicallyImpliedDeterminer = new JsonAlgorithm("Logically Implied Determiner", AlgorithmType.LOGICALLY_IMPLIED_DETERMINER);
    private JsonAlgorithm logicalTautologyDetector = new JsonAlgorithm("Logical Tautology Determiner", AlgorithmType.LOGICAL_TAUTOLOGY_DETERMINER);
    private JsonAlgorithm mainOperatorDetector = new JsonAlgorithm("Main Operator Detector", AlgorithmType.MAIN_OPERATOR_DETECTOR);
    private JsonAlgorithm openTreeDeterminer = new JsonAlgorithm("Open Tree Determiner", AlgorithmType.OPEN_TREE_DETERMINER);

    // Getters for object's attributes
    public JsonString getLabel() {
        return label;
    }

    public JsonAlgorithm getArgumentTruthTreeValidator() {
        return argumentTruthTreeValidator;
    }

    public JsonAlgorithm getClosedTreeDeterminer() {
        return closedTreeDeterminer;
    }

    public JsonAlgorithm getLogicalFalsehoodDeterminer() {
        return logicalFalsehoodDeterminer;
    }

    public JsonAlgorithm getLogicallyConsistentDeterminer() {
        return logicallyConsistentDeterminer;
    }

    public JsonAlgorithm getLogicallyContingentDeterminer() {
        return logicallyContingentDeterminer;
    }

    public JsonAlgorithm getLogicallyContradictoryDeterminer() {
        return logicallyContradictoryDeterminer;
    }

    public JsonAlgorithm getLogicallyContraryDeterminer() {
        return logicallyContraryDeterminer;
    }

    public JsonAlgorithm getLogicallyEquivalentDeterminer() {
        return logicallyEquivalentDeterminer;
    }

    public JsonAlgorithm getLogicallyImpliedDeterminer() {
        return logicallyImpliedDeterminer;
    }

    public JsonAlgorithm getLogicalTautologyDetector() {
        return logicalTautologyDetector;
    }

    public JsonAlgorithm getMainOperatorDetector() {
        return mainOperatorDetector;
    }

    public JsonAlgorithm getOpenTreeDeterminer() {
        return openTreeDeterminer;
    }

    // Setters for object's attributes.
    public void setLabel(JsonString label) {
        this.label = label;
    }

    public void setArgumentTruthTreeValidator(JsonAlgorithm argumentTruthTreeValidator) {
        this.argumentTruthTreeValidator = argumentTruthTreeValidator;
    }

    public void setClosedTreeDeterminer(JsonAlgorithm closedTreeDeterminer) {
        this.closedTreeDeterminer = closedTreeDeterminer;
    }

    public void setLogicalFalsehoodDeterminer(JsonAlgorithm logicalFalsehoodDeterminer) {
        this.logicalFalsehoodDeterminer = logicalFalsehoodDeterminer;
    }

    public void setLogicallyConsistentDeterminer(JsonAlgorithm logicallyConsistentDeterminer) {
        this.logicallyConsistentDeterminer = logicallyConsistentDeterminer;
    }

    public void setLogicallyContingentDeterminer(JsonAlgorithm logicallyContingentDeterminer) {
        this.logicallyContingentDeterminer = logicallyContingentDeterminer;
    }

    public void setLogicallyContradictoryDeterminer(JsonAlgorithm logicallyContradictoryDeterminer) {
        this.logicallyContradictoryDeterminer = logicallyContradictoryDeterminer;
    }

    public void setLogicallyContraryDeterminer(JsonAlgorithm logicallyContraryDeterminer) {
        this.logicallyContraryDeterminer = logicallyContraryDeterminer;
    }

    public void setLogicallyEquivalentDeterminer(JsonAlgorithm logicallyEquivalentDeterminer) {
        this.logicallyEquivalentDeterminer = logicallyEquivalentDeterminer;
    }

    public void setLogicallyImpliedDeterminer(JsonAlgorithm logicallyImpliedDeterminer) {
        this.logicallyImpliedDeterminer = logicallyImpliedDeterminer;
    }

    public void setLogicalTautologyDetector(JsonAlgorithm logicalTautologyDetector) {
        this.logicalTautologyDetector = logicalTautologyDetector;
    }

    public void setMainOperatorDetector(JsonAlgorithm mainOperatorDetector) {
        this.mainOperatorDetector = mainOperatorDetector;
    }

    public void setOpenTreeDeterminer(JsonAlgorithm openTreeDeterminer) {
        this.openTreeDeterminer = openTreeDeterminer;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(label);
            addAll(argumentTruthTreeValidator.toTranslate());
            addAll(closedTreeDeterminer.toTranslate());
            addAll(logicalFalsehoodDeterminer.toTranslate());
            addAll(logicallyConsistentDeterminer.toTranslate());
            addAll(logicallyContingentDeterminer.toTranslate());
            addAll(logicallyContradictoryDeterminer.toTranslate());
            addAll(logicallyContraryDeterminer.toTranslate());
            addAll(logicallyEquivalentDeterminer.toTranslate());
            addAll(logicallyImpliedDeterminer.toTranslate());
            addAll(logicalTautologyDetector.toTranslate());
            addAll(mainOperatorDetector.toTranslate());
            addAll(openTreeDeterminer.toTranslate());
        }};
    }

}