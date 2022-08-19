package com.flat.models.data.algorithms;

import com.flat.models.data.algorithms.general.GeneralAlgorithms;
import com.flat.models.data.algorithms.predicate.PredicateAlgorithms;
import com.flat.models.data.algorithms.propositional.PropositionalAlgorithms;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class Algorithms extends Translatable implements Serializable {

    private GeneralAlgorithms generalAlgorithms = new GeneralAlgorithms();
    private PredicateAlgorithms predicateAlgorithms = new PredicateAlgorithms();
    private PropositionalAlgorithms propositionalAlgorithms = new PropositionalAlgorithms();

    public Algorithms () {
    }

    // Getters for object's attributes.
    public GeneralAlgorithms getGeneralAlgorithms() {
        return generalAlgorithms;
    }

    public PredicateAlgorithms getPredicateAlgorithms() {
        return predicateAlgorithms;
    }

    public PropositionalAlgorithms getPropositionalAlgorithms() {
        return propositionalAlgorithms;
    }

    // Setters for object's attributes.
    public void setGeneralAlgorithms(GeneralAlgorithms generalAlgorithms) {
        this.generalAlgorithms = generalAlgorithms;
    }

    public void setPredicateAlgorithms(PredicateAlgorithms predicateAlgorithms) {
        this.predicateAlgorithms = predicateAlgorithms;
    }

    public void setPropositionalAlgorithms(PropositionalAlgorithms propositionalAlgorithms) {
        this.propositionalAlgorithms = propositionalAlgorithms;
    }

    @Override
    public String toString() {
        return "Algorithms{" + "generalAlgorithms=" + generalAlgorithms + ", predicateAlgorithms=" + predicateAlgorithms + ", propositionalAlgorithms=" + propositionalAlgorithms + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.generalAlgorithms);
            os.writeObject(this.predicateAlgorithms);
            os.writeObject(this.propositionalAlgorithms);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.generalAlgorithms = (GeneralAlgorithms) is.readObject();
            this.predicateAlgorithms = (PredicateAlgorithms) is.readObject();
            this.propositionalAlgorithms = (PropositionalAlgorithms) is.readObject();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(generalAlgorithms.toTranslate());
            addAll(predicateAlgorithms.toTranslate());
            addAll(propositionalAlgorithms.toTranslate());
        }};
    }

}