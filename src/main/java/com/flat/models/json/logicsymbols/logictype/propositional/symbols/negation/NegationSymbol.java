package com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes.NegationAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes.NegationSymbols;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbol extends LogicSymbol {

    public NegationSymbol () {
        super("Negation",
                new NegationSymbols(),
                "Negation",
                "This is the negation button.",
                "Not",
                new NegationAxioms());
    }

}