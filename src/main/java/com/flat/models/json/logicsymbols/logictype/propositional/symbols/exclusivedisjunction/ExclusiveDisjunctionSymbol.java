package com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.attributes.ExclusiveDisjunctionAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.attributes.ExclusiveDisjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionSymbol extends KeyedLogicSymbol {

    public ExclusiveDisjunctionSymbol () {
        super(
                ExclusiveDisjunctionSymbol.class,
                Type.PROPOSITIONAL,
                "Exclusive Disjunction",
                new ExclusiveDisjunctionSymbols(),
                "Exclusive Disjunction",
                "This is the exclusive or button.",
                "Either... or; xor",
                new ExclusiveDisjunctionAxioms()
        );
    }

}