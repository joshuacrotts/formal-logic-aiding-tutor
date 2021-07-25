package com.flat.models.data.logicsymbols.propositional.conjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.conjunction.ConjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionAxioms extends Axioms {

    public ConjunctionAxioms () {
        super(
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.EXPLANATION, "The statement (A ∧ B) is true if A and B are both true. Otherwise, it is false."),
                new KeyedTextArrayList(
                        ConjunctionSymbol.class,
                        LogicSymbol.Keys.EXAMPLES,
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (A ∧ B)"),
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. ((A ⊃ B) & (B ⊃ A))"),
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_3, "3. ((A ∨ B) & (A ∨ C))")
                )
        );
    }

    public ConjunctionAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}