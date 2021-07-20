package com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.ConjunctionSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionSymbols extends KeyedSymbols {

    public ConjunctionSymbols () {
        super(
                ConjunctionSymbol.class,
                "∧",
                new ArrayList <String> () {{
                    add("&");
                    add("·");
                    add("^");
                    add("∧");
                }}
        );
    }

}