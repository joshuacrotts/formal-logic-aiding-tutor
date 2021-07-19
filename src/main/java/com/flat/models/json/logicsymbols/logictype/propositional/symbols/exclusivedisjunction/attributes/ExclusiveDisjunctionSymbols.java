package com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionSymbols extends Symbols {

    public ExclusiveDisjunctionSymbols () {
        super("⊕",
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