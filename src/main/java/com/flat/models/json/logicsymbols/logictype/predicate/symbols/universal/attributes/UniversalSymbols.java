package com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalSymbols extends Symbols {

    public UniversalSymbols() {
        super("∀",
                new ArrayList <String> () {{
                    add("∀");
                    add("()");
                }}
        );
    }

}