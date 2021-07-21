package com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.attributes.UniversalAxioms;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.attributes.UniversalSymbols;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalSymbol extends KeyedLogicSymbol {

    public UniversalSymbol() {
        super(
                UniversalSymbol.class,
                Type.PREDICATE,
                "Universal",
                new UniversalSymbols(),
                "Universal Quantification",
                "This is the universal quantification button.",
                "For all; For any; For each; All; Every",
                new UniversalAxioms());
    }

}