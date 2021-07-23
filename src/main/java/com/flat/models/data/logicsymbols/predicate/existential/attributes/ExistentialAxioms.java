package com.flat.models.data.logicsymbols.predicate.existential.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ExistentialAxioms extends Axioms {

    public ExistentialAxioms () {
        super.setExplanation(new KeyedText(ExistentialSymbol.class, ExistentialSymbol.Keys.EXPLANATION, "(∀x)Px or (x)Px means the predicate P holds true for all inputs x from some domain D."));
        super.setExamples(new KeyedTextArrayList( new KeyedText(ExistentialSymbol.class, ExistentialSymbol.Keys.EXAMPLE_1, "1. (∃x)Px")));
    }

    public ExistentialAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}