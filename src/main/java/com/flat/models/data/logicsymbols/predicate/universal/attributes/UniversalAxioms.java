package com.flat.models.data.logicsymbols.predicate.universal.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;

/**
 *
 * @author christopherbrantley
 */
public class UniversalAxioms extends Axioms {

    public UniversalAxioms () {
        super.setExplanation(new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.EXPLANATION, "(∀x)Px or (x)Px means the predicate P holds true for all inputs x from some domain D."));
        super.setExamples(new KeyedTextArrayList(
                UniversalSymbol.class,
                LogicSymbol.Keys.EXAMPLES,
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (∀x)Px"),
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. (y)(Py & Qay)")
        ));
    }

    public UniversalAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}