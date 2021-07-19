package com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionAxioms extends Axioms {

    public ConjunctionAxioms () {
        super("The statement (A ∧ B) is true if A and B are"
                + " both true. Otherwise, it is false.",
                new ArrayList <String> () {{
                    add("1. (A ∧ B)");
                    add("2. ((A ⊃ B) & (B ⊃ A))");
                    add("3. ((A ∨ B) & (A ∨ C))");
                }}
        );
    }

}