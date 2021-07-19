package com.flat.models.json.logicsymbols;

import com.flat.models.json.JsonString;
import com.flat.models.json.logicsymbols.logictype.predicate.PredicateSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.PropositionalSymbols;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbols extends Translatable {
    private PropositionalSymbols propositional = new PropositionalSymbols();
    private PredicateSymbols predicate = new PredicateSymbols();

    public LogicSymbols () {
    }

    // Getters for object's attributes.
    public PropositionalSymbols getPropositional() {
        return propositional;
    }

    public PredicateSymbols getPredicate() {
        return predicate;
    }

    // Setters for object's attributes.
    public void setPropositional(PropositionalSymbols propositional) {
        this.propositional = propositional;
    }

    public void setPredicate(PredicateSymbols predicate) {
        this.predicate = predicate;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            addAll(propositional.toTranslate());
            addAll(predicate.toTranslate());
        }};
    }

}