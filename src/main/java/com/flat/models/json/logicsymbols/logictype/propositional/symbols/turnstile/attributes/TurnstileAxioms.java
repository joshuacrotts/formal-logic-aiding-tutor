package com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileAxioms extends Axioms {

    public TurnstileAxioms () {
        super("(x ⊢ y) means x proves (syntactically entails) y.",
                new ArrayList <String> () {{
                    add("1. (A → B), (B → C) ⊢ (A → C). The two"
                            + " premises syntactically entail the"
                            + " conclusion through hypothetical syllogism.");
                    add("2. (P ∨ Q), ~P ∴ Q. The two premises syntactically"
                            + " entail the conclusion through disjunctive"
                            + " syllogism.");
                }}
        );
    }

}