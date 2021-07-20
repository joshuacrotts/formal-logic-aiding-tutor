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
public class JsonPropositionalAlgorithms extends Translatable {

    public enum Keys implements JsonKey {
        PROPOSITIONAL_LOGIC_ALGORITHM,
        PROPOSITIONAL_TRUTH_TREE_GENERATOR,
        RANDOM_FORMULA_GENERATOR,
        TRUTH_TABLE_GENERATOR,
    }

    private KeyedJsonString label = new KeyedJsonString(JsonPropositionalAlgorithms.class, Keys.PROPOSITIONAL_LOGIC_ALGORITHM, "Propositional Logic Algorithm");
    private JsonAlgorithm propositionalTruthTreeGenerator = new JsonAlgorithm(new KeyedJsonString(JsonPropositionalAlgorithms.class, Keys.PROPOSITIONAL_TRUTH_TREE_GENERATOR,"Propositional Truth Tree Generator"), AlgorithmType.PROPOSITIONAL_TRUTH_TREE_GENERATOR);
    private JsonAlgorithm randomFormulaGenerator = new JsonAlgorithm(new KeyedJsonString(JsonPropositionalAlgorithms.class, Keys.RANDOM_FORMULA_GENERATOR,"Random Formula Generator"), AlgorithmType.RANDOM_PROPOSITIONAL_FORMULA);
    private JsonAlgorithm truthTableGenerator = new JsonAlgorithm(new KeyedJsonString(JsonPropositionalAlgorithms.class, Keys.PROPOSITIONAL_TRUTH_TREE_GENERATOR,"Truth Table Generator"), AlgorithmType.TRUTH_TABLE_GENERATOR);

    // Getters for object's attributes
    public KeyedJsonString getLabel() {
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
    public void setLabel(KeyedJsonString label) {
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
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(label);
            addAll(propositionalTruthTreeGenerator.toTranslate());
            addAll(randomFormulaGenerator.toTranslate());
            addAll(truthTableGenerator.toTranslate());
        }};
    }

}