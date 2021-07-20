package com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionSymbols extends KeyedSymbols {

    public ExclusiveDisjunctionSymbols () {
        super(
                ExclusiveDisjunctionSymbol.class,
                "⊕",
                new ArrayList <String> () {{
                    add("⊻");
                    add("≢");
                    add("⩒");
                    add("↮");
                    add("⩛");
                    add("⊕");
                }}
        );
    }

}