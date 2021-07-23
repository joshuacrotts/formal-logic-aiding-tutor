package com.flat.models.data.logicsymbols.propositional.doubleturnstile.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileAxioms extends Axioms {

    public DoubleTurnstileAxioms () {
        super(new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.EXPLANATION, "(x ⊨ y) means x models (semantically entails) y. In other words, the well-formed formula x ought to imply y, but the converse should not be true. The sentences x and y must also not be equivalent."),
                new KeyedTextArrayList(
                        new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. P ⊨ (P ∨ Q)")
                )
        );
    }

    public DoubleTurnstileAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}