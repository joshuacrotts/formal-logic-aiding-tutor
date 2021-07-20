package com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.DisjunctionSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionAxioms extends KeyedAxioms {

    public DisjunctionAxioms () {
        super(
                DisjunctionSymbol.class,
                "The statement (A ∨ B)"
                + " is true if A or B"
                + " (or both) are true."
                + " If both are false,"
                + " then it is false.",
                new ArrayList <String> () {{
                    add("1. (A ∨ B)");
                }}
        );
    }

}