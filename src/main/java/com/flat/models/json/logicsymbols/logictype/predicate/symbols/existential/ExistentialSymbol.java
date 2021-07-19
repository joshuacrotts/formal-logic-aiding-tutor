package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes.ExistentialAxioms;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes.ExistentialSymbols;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */

public class ExistentialSymbol extends LogicSymbol {

    public ExistentialSymbol () {
        super("Universal",
                new ExistentialSymbols(),
                "Existential Quantification",
                "This is the existential quantification button.",
                "There exists; Some; Many; At least one",
                new ExistentialAxioms());
    }

}