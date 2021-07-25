package com.flat.models.data.logicsymbols;

import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.logicsymbols.predicate.PredicateSymbols;
import com.flat.models.data.logicsymbols.propositional.PropositionalSymbols;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class LogicSymbols extends Translatable implements Serializable {
    private PredicateSymbols predicateSymbols = new PredicateSymbols();
    private PropositionalSymbols propositionalSymbols = new PropositionalSymbols();

    public enum SymbolKey {
        // Predicate.
        EXISTENTIAL,
        UNIVERSAL,
        // Propositional.
        BICONDITIONAL,
        CONJUNCTION,
        DISJUNCTION,
        DOUBLE_TURNSTILE,
        EXCLUSIVE_DISJUNCTION,
        IMPLICATION,
        NEGATION,
        TURNSTILE,
    }

    public LogicSymbols () {
    }

    // Getters for object's attributes.
    public PredicateSymbols getPredicateSymbols() {
        return predicateSymbols;
    }

    public PropositionalSymbols getPropositionalSymbols() {
        return propositionalSymbols;
    }

    // Setters for object's attributes.
    public void setPredicateSymbols(PredicateSymbols predicateSymbols) {
        this.predicateSymbols = predicateSymbols;
    }

    public void setPropositionalSymbols(PropositionalSymbols propositionalSymbols) {
        this.propositionalSymbols = propositionalSymbols;
    }

    @Override
    public String toString() {
        return "LogicSymbols{" + "predicateSymbols=" + predicateSymbols + ", propositionalSymbols=" + propositionalSymbols + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.predicateSymbols);
            os.writeObject(this.propositionalSymbols);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.predicateSymbols = (PredicateSymbols) is.readObject();
            this.propositionalSymbols = (PropositionalSymbols) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(predicateSymbols.toTranslate());
            addAll(propositionalSymbols.toTranslate());
        }};
    }

}