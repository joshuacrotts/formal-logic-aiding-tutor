package com.flat.models.data.logicsymbols.propositional.disjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionAxioms extends Axioms {

    public DisjunctionAxioms () {
        super(new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.EXPLANATION, "The statement (A ∨ B) is true if A or B (or both) are true. If both are false, then it is false."),
                new KeyedTextArrayList(
                        new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (A ∨ B)")
                )
        );
    }

    public DisjunctionAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}