package com.flat.models.json.settings.tabs.advance.content;

import com.flat.models.json.JsonString;
import com.flat.models.json.settings.tabs.advance.content.alert.JsonAdvanceAlert;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonAdvancePane extends Translatable {
    private JsonString predicateNDV = new JsonString("Predicate natural deduction validator");
    private JsonString predicateTruthTree = new JsonString("Predicate truth tree");
    private JsonString propositionalNDV = new JsonString("Propositional natural deduction validator");
    private JsonString propositionalTruthTree = new JsonString("Propositional truth tree");
    private JsonString truthTableGenerator = new JsonString("Truth table generator");
    private JsonAdvanceAlert advanceAlert = new JsonAdvanceAlert();

    // Getters for object's attributes.
    public JsonString getPredicateNDV() {
        return predicateNDV;
    }

    public JsonString getPredicateTruthTree() {
        return predicateTruthTree;
    }

    public JsonString getPropositionalNDV() {
        return propositionalNDV;
    }

    public JsonString getPropositionalTruthTree() {
        return propositionalTruthTree;
    }

    public JsonString getTruthTableGenerator() {
        return truthTableGenerator;
    }

    public JsonAdvanceAlert getAdvanceAlert() {
        return advanceAlert;
    }

    // Setters for object's attributes.
    public void setPredicateNDV(JsonString predicateNDV) {
        this.predicateNDV = predicateNDV;
    }

    public void setPredicateTruthTree(JsonString predicateTruthTree) {
        this.predicateTruthTree = predicateTruthTree;
    }

    public void setPropositionalNDV(JsonString propositionalNDV) {
        this.propositionalNDV = propositionalNDV;
    }

    public void setPropositionalTruthTree(JsonString propositionalTruthTree) {
        this.propositionalTruthTree = propositionalTruthTree;
    }

    public void setTruthTableGenerator(JsonString truthTableGenerator) {
        this.truthTableGenerator = truthTableGenerator;
    }

    public void setAdvanceAlert(JsonAdvanceAlert advanceAlert) {
        this.advanceAlert = advanceAlert;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString> () {{
            add(predicateNDV);
            add(predicateTruthTree);
            add(propositionalNDV);
            add(propositionalTruthTree);
            add(truthTableGenerator);
            addAll(advanceAlert.toTranslate());
        }};
    }

}