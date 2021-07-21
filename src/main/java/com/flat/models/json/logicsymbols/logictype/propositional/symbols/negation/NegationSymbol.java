package com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes.NegationAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes.NegationSymbols;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbol extends KeyedLogicSymbol {

    public NegationSymbol () {
        super(
                NegationSymbol.class,
                Type.PROPOSITIONAL,
                "Negation",
                new NegationSymbols(),
                "Negation",
                "This is the negation button.",
                "Not",
                new NegationAxioms());
    }

}