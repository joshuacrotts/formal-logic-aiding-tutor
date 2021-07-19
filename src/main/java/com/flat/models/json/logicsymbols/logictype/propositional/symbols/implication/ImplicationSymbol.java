package com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.attributes.ImplicationAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.attributes.ImplicationSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationSymbol extends LogicSymbol {

    public ImplicationSymbol () {
        super("Implication",
                new ImplicationSymbols(),
                "Implication",
                "This is the implication button.",
                "implies; if ... then",
                new ImplicationAxioms());
    }

}