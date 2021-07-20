package com.flat.models.json.settings.tabs.advance.content;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.settings.tabs.advance.content.alert.JsonAdvanceAlert;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAdvancePane extends Translatable {

    public enum Keys implements JsonKey {
        PREDICATE_NDV,
        PREDICATE_TRUTH_TRUTH,
        PROPOSITIONAL_NDV,
        PROPOSITIONAL_TRUTH_TREE,
        TRUTH_TABLE_GENERATOR
    }

    private KeyedJsonString predicateNDV = new KeyedJsonString(JsonAdvancePane.class, Keys.PREDICATE_NDV, "Predicate natural deduction validator");
    private KeyedJsonString predicateTruthTree = new KeyedJsonString(JsonAdvancePane.class, Keys.PREDICATE_TRUTH_TRUTH, "Predicate truth tree");
    private KeyedJsonString propositionalNDV = new KeyedJsonString(JsonAdvancePane.class, Keys.PROPOSITIONAL_NDV, "Propositional natural deduction validator");
    private KeyedJsonString propositionalTruthTree = new KeyedJsonString(JsonAdvancePane.class, Keys.PROPOSITIONAL_TRUTH_TREE, "Propositional truth tree");
    private KeyedJsonString truthTableGenerator = new KeyedJsonString(JsonAdvancePane.class, Keys.TRUTH_TABLE_GENERATOR, "Truth table generator");
    private JsonAdvanceAlert advanceAlert = new JsonAdvanceAlert();

    // Getters for object's attributes.
    public KeyedJsonString getPredicateNDV() {
        return predicateNDV;
    }

    public KeyedJsonString getPredicateTruthTree() {
        return predicateTruthTree;
    }

    public KeyedJsonString getPropositionalNDV() {
        return propositionalNDV;
    }

    public KeyedJsonString getPropositionalTruthTree() {
        return propositionalTruthTree;
    }

    public KeyedJsonString getTruthTableGenerator() {
        return truthTableGenerator;
    }

    public JsonAdvanceAlert getAdvanceAlert() {
        return advanceAlert;
    }

    // Setters for object's attributes.
    public void setPredicateNDV(KeyedJsonString predicateNDV) {
        this.predicateNDV = predicateNDV;
    }

    public void setPredicateTruthTree(KeyedJsonString predicateTruthTree) {
        this.predicateTruthTree = predicateTruthTree;
    }

    public void setPropositionalNDV(KeyedJsonString propositionalNDV) {
        this.propositionalNDV = propositionalNDV;
    }

    public void setPropositionalTruthTree(KeyedJsonString propositionalTruthTree) {
        this.propositionalTruthTree = propositionalTruthTree;
    }

    public void setTruthTableGenerator(KeyedJsonString truthTableGenerator) {
        this.truthTableGenerator = truthTableGenerator;
    }

    public void setAdvanceAlert(JsonAdvanceAlert advanceAlert) {
        this.advanceAlert = advanceAlert;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(predicateNDV);
            add(predicateTruthTree);
            add(propositionalNDV);
            add(propositionalTruthTree);
            add(truthTableGenerator);
            addAll(advanceAlert.toTranslate());
        }};
    }

}