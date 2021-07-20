package com.flat.models.json.algorithm.type.general;

import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.algorithm.JsonAlgorithm;
import com.flat.models.json.algorithm.enums.AlgorithmType;
import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonGeneralAlgorithms extends Translatable {

    public enum Keys implements JsonKey {
        GENERAL_LOGIC_ALGORITHM,
        ARGUMENT_TRUTH_TREE_VALIDATOR,
        CLOSED_TREE_DETERMINER,
        LOGICAL_FALSEHOOD_DETERMINER,
        LOGICALLY_CONSISTENT_DETERMINER,
        LOGICALLY_CONTINGENT_DETERMINER,
        LOGICALLY_CONTRADICTORY_DETERMINER,
        LOGICALLY_CONTRARY_DETERMINER,
        LOGICALLY_EQUIVALENT_DETERMINER,
        LOGICALLY_IMPLIED_DETERMINER,
        LOGICAL_TAUTOLOGY_DETERMINER,
        MAIN_OPERATOR_DETECTOR,
        OPEN_TREE_DETERMINER,
        SEMANTIC_ENTAILMENT_DETERMINER,
    }

    private KeyedJsonString label = new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.GENERAL_LOGIC_ALGORITHM, "General Logic Algorithms");
    private JsonAlgorithm argumentTruthTreeValidator = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.ARGUMENT_TRUTH_TREE_VALIDATOR, "Argument Truth Tree Validator"), AlgorithmType.ARGUMENT_TRUTH_TREE_VALIDATOR);
    private JsonAlgorithm closedTreeDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.CLOSED_TREE_DETERMINER, "Closed Tree Determiner"), AlgorithmType.CLOSED_TREE_DETERMINER);
    private JsonAlgorithm logicalFalsehoodDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICAL_FALSEHOOD_DETERMINER, "Logical Falsehood Determiner"), AlgorithmType.LOGICAL_FALSEHOOD_DETERMINER);
    private JsonAlgorithm logicallyConsistentDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_CONSISTENT_DETERMINER, "Logically Consistent Determiner"), AlgorithmType.LOGICALLY_CONSISTENT_DETERMINER);
    private JsonAlgorithm logicallyContingentDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_CONTINGENT_DETERMINER, "Logically Contingent Determiner"), AlgorithmType.LOGICALLY_CONTINGENT_DETERMINER);
    private JsonAlgorithm logicallyContradictoryDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_CONTRADICTORY_DETERMINER, "Logically Contradictory Determiner"), AlgorithmType.LOGICALLY_CONTRADICTORY_DETERMINER);
    private JsonAlgorithm logicallyContraryDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_CONTRARY_DETERMINER, "Logically Contrary Determiner"), AlgorithmType.LOGICALLY_CONTRARY_DETERMINER);
    private JsonAlgorithm logicallyEquivalentDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_EQUIVALENT_DETERMINER, "Logically Equivalent Determiner"), AlgorithmType.LOGICALLY_EQUIVALENT_DETERMINER);
    private JsonAlgorithm logicallyImpliedDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICALLY_IMPLIED_DETERMINER, "Logically Implied Determiner"), AlgorithmType.LOGICALLY_IMPLIED_DETERMINER);
    private JsonAlgorithm logicalTautologyDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.LOGICAL_TAUTOLOGY_DETERMINER, "Logical Tautology Determiner"), AlgorithmType.LOGICAL_TAUTOLOGY_DETERMINER);
    private JsonAlgorithm mainOperatorDetector = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.MAIN_OPERATOR_DETECTOR, "Main Operator Detector"), AlgorithmType.MAIN_OPERATOR_DETECTOR);
    private JsonAlgorithm openTreeDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.OPEN_TREE_DETERMINER, "Open Tree Determiner"), AlgorithmType.OPEN_TREE_DETERMINER);
    private JsonAlgorithm semanticEntailmentDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonGeneralAlgorithms.class, Keys.SEMANTIC_ENTAILMENT_DETERMINER, "Semantic Entailment Determiner"), AlgorithmType.SEMANTIC_ENTAILMENT_DETERMINER);

    // Getters for object's attributes
    public KeyedJsonString getLabel() {
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

    public JsonAlgorithm getLogicalTautologyDeterminer() {
        return logicalTautologyDeterminer;
    }

    public JsonAlgorithm getMainOperatorDetector() {
        return mainOperatorDetector;
    }

    public JsonAlgorithm getOpenTreeDeterminer() {
        return openTreeDeterminer;
    }

    public JsonAlgorithm getSemanticEntailmentDeterminer() {
        return semanticEntailmentDeterminer;
    }

    // Setters for object's attributes.
    public void setLabel(KeyedJsonString label) {
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

    public void setLogicalTautologyDeterminer(JsonAlgorithm logicalTautologyDeterminer) {
        this.logicalTautologyDeterminer = logicalTautologyDeterminer;
    }

    public void setMainOperatorDetector(JsonAlgorithm mainOperatorDetector) {
        this.mainOperatorDetector = mainOperatorDetector;
    }

    public void setOpenTreeDeterminer(JsonAlgorithm openTreeDeterminer) {
        this.openTreeDeterminer = openTreeDeterminer;
    }

    public void setSemanticEntailmentDeterminer(JsonAlgorithm semanticEntailmentDeterminer) {
        this.semanticEntailmentDeterminer = semanticEntailmentDeterminer;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
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
            addAll(logicalTautologyDeterminer.toTranslate());
            addAll(mainOperatorDetector.toTranslate());
            addAll(openTreeDeterminer.toTranslate());
            addAll(semanticEntailmentDeterminer.toTranslate());
        }};
    }

}