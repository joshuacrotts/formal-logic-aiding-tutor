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
public class JsonPropositionalAlgorithms extends Translatable {
    private JsonString label = new JsonString("Propositional Logic Algorithm");
    private JsonAlgorithm propositionalTruthTreeGenerator = new JsonAlgorithm("Propositional Truth Tree Generator", AlgorithmType.PROPOSITIONAL_TRUTH_TREE_GENERATOR);
    private JsonAlgorithm randomFormulaGenerator = new JsonAlgorithm("Random Formula Generator", AlgorithmType.RANDOM_PROPOSITIONAL_FORMULA);
    private JsonAlgorithm truthTableGenerator = new JsonAlgorithm("Truth Table Generator", AlgorithmType.TRUTH_TABLE_GENERATOR);

    // Getters for object's attributes
    public JsonString getLabel() {
        return label;
    }

    public JsonAlgorithm getPropositionalTruthTreeGenerator() {
        return propositionalTruthTreeGenerator;
    }

    public JsonAlgorithm getRandomFormulaGenerator() {
        return randomFormulaGenerator;
    }

    public JsonAlgorithm getTruthTableGenerator() {
        return truthTableGenerator;
    }

    // Setters for object's attributes.
    public void setLabel(JsonString label) {
        this.label = label;
    }

    public void setPropositionalTruthTreeGenerator(JsonAlgorithm propositionalTruthTreeGenerator) {
        this.propositionalTruthTreeGenerator = propositionalTruthTreeGenerator;
    }

    public void setRandomFormulaGenerator(JsonAlgorithm randomFormulaGenerator) {
        this.randomFormulaGenerator = randomFormulaGenerator;
    }

    public void setTruthTableGenerator(JsonAlgorithm truthTableGenerator) {
        this.truthTableGenerator = truthTableGenerator;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(label);
            addAll(propositionalTruthTreeGenerator.toTranslate());
            addAll(randomFormulaGenerator.toTranslate());
            addAll(truthTableGenerator.toTranslate());
        }};
    }

}