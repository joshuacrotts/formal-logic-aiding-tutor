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

    @Override
    public LinkedList<JsonString> toTranslate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}