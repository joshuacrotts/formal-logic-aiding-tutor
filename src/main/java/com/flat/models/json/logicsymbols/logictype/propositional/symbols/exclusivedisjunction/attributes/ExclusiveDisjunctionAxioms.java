package com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionAxioms extends Axioms {

    public ExclusiveDisjunctionAxioms () {
        super("The statement (A ⊕ B) is true when either"
                + " A or B are true, but not both are true.",
                new ArrayList <String> () {{
                    add("1. A common example of the exclusive"
                            + " or operator comes up when talking"
                            + " about exclusivity among events. In"
                            + " other words, if we have two propositions"
                            + " P and Q, then either P can be true or Q"
                            + " can be true. However, P and Q cannot be true."
                            + " Also, P and Q cannot be false.");
                    add("2. Suppose A is true and B is false. Then (A ⊕ B) is true.");
                    add("3. Suppose A is true and B is false. Then ((A → B) ⊕ (B → A))"
                            + " is true. (A → B) is false, and (B → A) is true. Thus,"
                            + " the operands are different which results in true.");
                }}
        );
    }

}