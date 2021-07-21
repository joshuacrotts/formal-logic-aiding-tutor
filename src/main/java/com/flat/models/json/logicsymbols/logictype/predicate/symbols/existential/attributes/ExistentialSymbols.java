package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.ExistentialSymbol;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialSymbols extends KeyedSymbols implements Serializable {

    public ExistentialSymbols() {
        super(
                ExistentialSymbol.class,
                "∃",
                new ArrayList <String> () {{
                    add("∃");
                }}
        );
    }

}