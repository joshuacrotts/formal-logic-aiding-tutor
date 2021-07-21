package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes.ExistentialAxioms;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes.ExistentialSymbols;
import java.io.Serializable;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialSymbol extends KeyedLogicSymbol implements Serializable {

    public ExistentialSymbol () {
        super(
                ExistentialSymbol.class,
                Type.PREDICATE,
                "Universal",
                new ExistentialSymbols(),
                "Existential Quantification",
                "This is the existential quantification button.",
                "There exists; Some; Many; At least one",
                new ExistentialAxioms());
    }

}