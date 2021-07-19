package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes;

import com.flat.models.json.JsonString;
import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialAxioms extends Axioms {

    public ExistentialAxioms() {
        super(new JsonString("(∃x)Px means there is at least one input x in a domain D that satisfies the proposition P (that makes P true)."),
                new ArrayList <JsonString> () {{
                    add(new JsonString("1. (∃x)Px"));
                }}
        );
    }

}