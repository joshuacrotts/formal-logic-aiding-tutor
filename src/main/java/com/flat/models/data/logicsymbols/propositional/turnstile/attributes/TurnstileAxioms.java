package com.flat.models.data.logicsymbols.propositional.turnstile.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileAxioms extends Axioms {

    public TurnstileAxioms () {
        super(new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.EXPLANATION, "(x ⊢ y) means x proves (syntactically entails) y."),
                new KeyedTextArrayList(
                        new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (A → B), (B → C) ⊢ (A → C). The two premises syntactically entail the conclusion through hypothetical syllogism."),
                        new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. (P ∨ Q), ~P ∴ Q. The two premises syntactically entail the conclusion through disjunctive syllogism.")
                )
        );
    }

    public TurnstileAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}