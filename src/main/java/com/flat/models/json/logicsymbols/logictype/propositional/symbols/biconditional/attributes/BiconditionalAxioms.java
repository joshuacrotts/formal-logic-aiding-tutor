package com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.BiconditionalSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalAxioms extends KeyedAxioms {

    public BiconditionalAxioms () {
        super(
                BiconditionalSymbol.class,
                "(A ⇔ B) is true when A and B are the same."
                + " This means that A must be true and B"
                + " must be true for this sentence to be true."
                + " Likewise, A must be false and B must be false"
                + " for this sentence to be true. When they differ,"
                + " the sentence is false.",
                new ArrayList <String> () {{
                    add("1. (A ⇔ B)");
                }}
        );
    }

}