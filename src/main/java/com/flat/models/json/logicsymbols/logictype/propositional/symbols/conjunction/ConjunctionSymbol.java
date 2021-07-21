package com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.attributes.ConjunctionAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.attributes.ConjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionSymbol extends KeyedLogicSymbol {

    public ConjunctionSymbol () {
        super(
                ConjunctionSymbol.class,
                Type.PROPOSITIONAL,
                "Conjunction",
                new ConjunctionSymbols(),
                "Conjunction",
                "This is the conjunction button.",
                "And",
                new ConjunctionAxioms()
        );
    }

}