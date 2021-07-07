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
public class JsonPredicateAlgorithms extends Translatable {
    private JsonString label = new JsonString("Predicate Logic Algorithms");
    private JsonAlgorithm boundVariableDetector = new JsonAlgorithm("", AlgorithmType.BOUND_VARIABLE_DETECTOR);
    private JsonAlgorithm closedSentenceDeterminer = new JsonAlgorithm("", AlgorithmType.CLOSED_SENTENCE_DETERMINER);
    private JsonAlgorithm freeVariableDetector = new JsonAlgorithm("", AlgorithmType.FREE_VARIABLE_DETECTOR);
    private JsonAlgorithm groundSentenceDeterminer = new JsonAlgorithm("", AlgorithmType.GROUND_SENTENCE_DETERMINER);
    private JsonAlgorithm openSentenceDeterminer = new JsonAlgorithm("", AlgorithmType.OPEN_SENTENCE_DETERMINER);
    private JsonAlgorithm predicatetruthTreeGenerator = new JsonAlgorithm("", AlgorithmType.PREDICATE_TRUTH_TREE_GENERATOR);

    // Getters for object's attributes
    public JsonString getLabel() {
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

    // Setters for object's attributes.
    public void setLabel(JsonString label) {
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

    @Override
    public LinkedList<JsonString> toTranslate() {
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