package com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes.DisjunctionAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes.DisjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbol extends LogicSymbol {

    public DisjunctionSymbol () {
        super("Disjunction",
                new DisjunctionSymbols(),
                "Disjunction",
                "This is the disjunction button.",
                "Or",
                new DisjunctionAxioms()
        );
    }

}