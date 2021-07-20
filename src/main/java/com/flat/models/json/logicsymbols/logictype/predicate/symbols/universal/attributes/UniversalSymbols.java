package com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.UniversalSymbol;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalSymbols extends KeyedSymbols {

    public UniversalSymbols () {
        super(
                UniversalSymbol.class,
                "∀",
                new ArrayList <String> () {{
                    add("∀");
                    add("()");
                }}
        );
    }

}