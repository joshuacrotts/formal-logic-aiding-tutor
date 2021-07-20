package com.flat.models.json.algorithm.type;

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
public class JsonPredicateAlgorithms extends Translatable {

    public enum Keys implements JsonKey {
        PREDICATE_LOGIC_ALGORITHMS,
        BOUND_VARIABLE_DETECTOR,
        CLOSED_SENTENCE_DETERMINER,
        FREE_VARIABLE_DETECTOR,
        GROUND_SENTENCE_DETERMINER,
        OPEN_SENTENCE_DETERMINER,
        PREDICATE_TRUTH_TREE_GENERATOR,
        RANDOM_FORMULA_GENERATOR,
    }

    private KeyedJsonString label = new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.PREDICATE_LOGIC_ALGORITHMS, "Predicate Logic Algorithms");
    private JsonAlgorithm boundVariableDetector = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.BOUND_VARIABLE_DETECTOR, "Bound Variable Detector"), AlgorithmType.BOUND_VARIABLE_DETECTOR);
    private JsonAlgorithm closedSentenceDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.CLOSED_SENTENCE_DETERMINER, "Closed Sentence Determiner"), AlgorithmType.CLOSED_SENTENCE_DETERMINER);
    private JsonAlgorithm freeVariableDetector = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.FREE_VARIABLE_DETECTOR, "Free Variable Detector"), AlgorithmType.FREE_VARIABLE_DETECTOR);
    private JsonAlgorithm groundSentenceDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.GROUND_SENTENCE_DETERMINER, "Ground Sentence Determiner"), AlgorithmType.GROUND_SENTENCE_DETERMINER);
    private JsonAlgorithm openSentenceDeterminer = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.OPEN_SENTENCE_DETERMINER, "Open Sentence Determiner"), AlgorithmType.OPEN_SENTENCE_DETERMINER);
    private JsonAlgorithm predicatetruthTreeGenerator = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.PREDICATE_TRUTH_TREE_GENERATOR, "Predicate Truth Tree Generator"), AlgorithmType.PREDICATE_TRUTH_TREE_GENERATOR);
    private JsonAlgorithm randomFormulaGenerator = new JsonAlgorithm(new KeyedJsonString(JsonPredicateAlgorithms.class, Keys.RANDOM_FORMULA_GENERATOR, "Random Formula Generator"), AlgorithmType.RANDOM_PREDICATE_FORMULA);

    // Getters for object's attributes
    public KeyedJsonString getLabel() {
        return label;
    }

    public JsonAlgorithm getBoundVariableDetector() {
        return boundVariableDetector;
    }

    public JsonAlgorithm getClosedSentenceDeterminer() {
        return closedSentenceDeterminer;
    }

    public JsonAlgorithm getFreeVariableDetector() {
        return freeVariableDetector;
    }

    public JsonAlgorithm getGroundSentenceDeterminer() {
        return groundSentenceDeterminer;
    }

    public JsonAlgorithm getOpenSentenceDeterminer() {
        return openSentenceDeterminer;
    }

    public JsonAlgorithm getPredicatetruthTreeGenerator() {
        return predicatetruthTreeGenerator;
    }

    public JsonAlgorithm getRandomFormulaGenerator() {
        return randomFormulaGenerator;
    }

    // Setters for object's attributes.
    public void setLabel(KeyedJsonString label) {
        this.label = label;
    }

    public void setBoundVariableDetector(JsonAlgorithm boundVariableDetector) {
        this.boundVariableDetector = boundVariableDetector;
    }

    public void setClosedSentenceDeterminer(JsonAlgorithm closedSentenceDeterminer) {
        this.closedSentenceDeterminer = closedSentenceDeterminer;
    }

    public void setFreeVariableDetector(JsonAlgorithm freeVariableDetector) {
        this.freeVariableDetector = freeVariableDetector;
    }

    public void setGroundSentenceDeterminer(JsonAlgorithm groundSentenceDeterminer) {
        this.groundSentenceDeterminer = groundSentenceDeterminer;
    }

    public void setOpenSentenceDeterminer(JsonAlgorithm openSentenceDeterminer) {
        this.openSentenceDeterminer = openSentenceDeterminer;
    }

    public void setPredicatetruthTreeGenerator(JsonAlgorithm predicatetruthTreeGenerator) {
        this.predicatetruthTreeGenerator = predicatetruthTreeGenerator;
    }

    public void setRandomFormulaGenerator(JsonAlgorithm randomFormulaGenerator) {
        this.randomFormulaGenerator = randomFormulaGenerator;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(label);
            addAll(boundVariableDetector.toTranslate());
            addAll(closedSentenceDeterminer.toTranslate());
            addAll(freeVariableDetector.toTranslate());
            addAll(groundSentenceDeterminer.toTranslate());
            addAll(openSentenceDeterminer.toTranslate());
            addAll(predicatetruthTreeGenerator.toTranslate());
        }};
    }

}