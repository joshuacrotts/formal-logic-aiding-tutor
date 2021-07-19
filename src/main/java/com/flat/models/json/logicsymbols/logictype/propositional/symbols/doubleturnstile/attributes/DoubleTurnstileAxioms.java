package com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileAxioms extends Axioms {

    public DoubleTurnstileAxioms () {
        super("(x ⊨ y) means x models (semantically entails) y."
                + " In other words, the well-formed formula x ought"
                + " to imply y, but the converse should not be true."
                + " The sentences x and y must also not be equivalent.",
                new ArrayList <String> () {{
                    add("1. P ⊨ (P ∨ Q)");
                }}
        );
    }

}