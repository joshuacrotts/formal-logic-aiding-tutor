package com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.ExistentialSymbol;
import java.io.Serializable;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialAxioms extends KeyedAxioms implements Serializable {

    public ExistentialAxioms() {
        super(
                ExistentialSymbol.class,
                "(∃x)Px means there is at least one input x in a domain D that satisfies the proposition P (that makes P true).",
                new ArrayList <String> () {{
                    add("1. (∃x)Px");
                }}
        );
    }

}