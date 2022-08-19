package com.flat.models.data.settings.tabs.advanced.content;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.settings.tabs.advanced.content.alert.AdvancedAlert;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class AdvancedPane extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        PREDICATE_NDV,
        PREDICATE_TRUTH_TRUTH,
        PROPOSITIONAL_NDV,
        PROPOSITIONAL_TRUTH_TREE,
        TRUTH_TABLE_GENERATOR
    }

    private KeyedText predicateNDV = new KeyedText(AdvancedPane.class, Keys.PREDICATE_NDV, "Predicate natural deduction validator");
    private KeyedText predicateTruthTree = new KeyedText(AdvancedPane.class, Keys.PREDICATE_TRUTH_TRUTH, "Predicate truth tree");
    private KeyedText propositionalNDV = new KeyedText(AdvancedPane.class, Keys.PROPOSITIONAL_NDV, "Propositional natural deduction validator");
    private KeyedText propositionalTruthTree = new KeyedText(AdvancedPane.class, Keys.PROPOSITIONAL_TRUTH_TREE, "Propositional truth tree");
    private KeyedText truthTableGenerator = new KeyedText(AdvancedPane.class, Keys.TRUTH_TABLE_GENERATOR, "Truth table generator");
    private AdvancedAlert advancedAlert = new AdvancedAlert();

    public AdvancedPane () {
    }

    // Getters for object's attributes.
    public KeyedText getPredicateNDV() {
        return predicateNDV;
    }

    public KeyedText getPredicateTruthTree() {
        return predicateTruthTree;
    }

    public KeyedText getPropositionalNDV() {
        return propositionalNDV;
    }

    public KeyedText getPropositionalTruthTree() {
        return propositionalTruthTree;
    }

    public KeyedText getTruthTableGenerator() {
        return truthTableGenerator;
    }

    public AdvancedAlert getAdvancedAlert() {
        return advancedAlert;
    }

    // Setters for object's attributes.
    public void setPredicateNDV(KeyedText predicateNDV) {
        this.predicateNDV = predicateNDV;
    }

    public void setPredicateTruthTree(KeyedText predicateTruthTree) {
        this.predicateTruthTree = predicateTruthTree;
    }

    public void setPropositionalNDV(KeyedText propositionalNDV) {
        this.propositionalNDV = propositionalNDV;
    }

    public void setPropositionalTruthTree(KeyedText propositionalTruthTree) {
        this.propositionalTruthTree = propositionalTruthTree;
    }

    public void setTruthTableGenerator(KeyedText truthTableGenerator) {
        this.truthTableGenerator = truthTableGenerator;
    }

    public void setAdvancedAlert(AdvancedAlert advancedAlert) {
        this.advancedAlert = advancedAlert;
    }

    @Override
    public String toString() {
        return "AdvancedPane{" + "predicateNDV=" + predicateNDV + ", predicateTruthTree=" + predicateTruthTree + ", propositionalNDV=" + propositionalNDV + ", propositionalTruthTree=" + propositionalTruthTree + ", truthTableGenerator=" + truthTableGenerator + ", advancedAlert=" + advancedAlert + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.predicateNDV);
            os.writeObject(this.predicateTruthTree);
            os.writeObject(this.propositionalNDV);
            os.writeObject(this.propositionalTruthTree);
            os.writeObject(this.truthTableGenerator);
            os.writeObject(this.advancedAlert);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.predicateNDV = (KeyedText) is.readObject();
            this.predicateTruthTree = (KeyedText) is.readObject();
            this.propositionalNDV = (KeyedText) is.readObject();
            this.propositionalTruthTree = (KeyedText) is.readObject();
            this.truthTableGenerator = (KeyedText) is.readObject();
            this.advancedAlert = (AdvancedAlert) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(predicateNDV);
            add(predicateTruthTree);
            add(propositionalNDV);
            add(propositionalTruthTree);
            add(truthTableGenerator);
            addAll(advancedAlert.toTranslate());
        }};
    }

}