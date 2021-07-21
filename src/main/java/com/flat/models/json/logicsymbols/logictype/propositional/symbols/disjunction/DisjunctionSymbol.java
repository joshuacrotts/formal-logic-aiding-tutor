package com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes.DisjunctionAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes.DisjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbol extends KeyedLogicSymbol {

    public DisjunctionSymbol () {
        super(
                DisjunctionSymbol.class,
                Type.PROPOSITIONAL,
                "Disjunction",
                new DisjunctionSymbols(),
                "Disjunction",
                "This is the disjunction button.",
                "Or",
                new DisjunctionAxioms()
        );
    }

}