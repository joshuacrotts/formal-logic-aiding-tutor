package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialSymbols extends Symbols {

    public ExistentialSymbols() {
        super("∃",
                new ArrayList <String> () {{
                    add("∃");
                }}
        );
    }

}