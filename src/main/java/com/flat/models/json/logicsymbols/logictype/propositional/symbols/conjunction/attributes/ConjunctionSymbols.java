package com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionSymbols extends Symbols {

    public ConjunctionSymbols () {
        super("∧",
                new ArrayList <String> () {{
                    add("&");
                    add("·");
                    add("^");
                    add("∧");
                }}
        );
    }

}