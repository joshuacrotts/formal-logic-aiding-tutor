package com.flat.models.json.algorithm;

import com.flat.models.json.JsonString;
import com.flat.models.json.algorithm.type.general.JsonGeneralAlgorithms;
import com.flat.models.json.algorithm.type.JsonPredicateAlgorithms;
import com.flat.models.json.algorithm.type.JsonPropositionalAlgorithms;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAlgorithms extends Translatable {
    private JsonGeneralAlgorithms generalAlgorithms = new JsonGeneralAlgorithms();
    private JsonPropositionalAlgorithms propositionalAlgorithms = new JsonPropositionalAlgorithms();
    private JsonPredicateAlgorithms predicateAlgorithms = new JsonPredicateAlgorithms();

    // Getters for object's attributes.
    public JsonGeneralAlgorithms getGeneralAlgorithms() {
        return generalAlgorithms;
    }

    public JsonPropositionalAlgorithms getPropositionalAlgorithms() {
        return propositionalAlgorithms;
    }

    public JsonPredicateAlgorithms getPredicateAlgorithms() {
        return predicateAlgorithms;
    }

    // Setters for object's attributes.
    public void setGeneralAlgorithms(JsonGeneralAlgorithms generalAlgorithms) {
        this.generalAlgorithms = generalAlgorithms;
    }

    public void setPropositionalAlgorithms(JsonPropositionalAlgorithms propositionalAlgorithms) {
        this.propositionalAlgorithms = propositionalAlgorithms;
    }

    public void setPredicateAlgorithms(JsonPredicateAlgorithms predicateAlgorithms) {
        this.predicateAlgorithms = predicateAlgorithms;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            addAll(generalAlgorithms.toTranslate());
            addAll(propositionalAlgorithms.toTranslate());
            addAll(predicateAlgorithms.toTranslate());
        }};
    }

}