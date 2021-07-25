package com.flat.models.data.logicsymbols.propositional.biconditional.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.biconditional.BiconditionalSymbol;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalAxioms extends Axioms {

    public BiconditionalAxioms () {
        super(
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.EXPLANATION, "(A ⇔ B) is true when A and B are the same. This means that A must be true and B must be true for this sentence to be true. Likewise, A must be false and B must be false for this sentence to be true. When they differ, the sentence is false."),
                new KeyedTextArrayList(
                        BiconditionalSymbol.class,
                        LogicSymbol.Keys.EXAMPLES,
                        new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (A ⇔ B)")
                )
        );
    }

    public BiconditionalAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}