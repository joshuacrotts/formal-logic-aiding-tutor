package com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationAxioms extends Axioms {

    public ImplicationAxioms () {
        super("(A ⇒ B) is false when A is true and B is false,"
                + " but true otherwise. The implication operator"
                + " is often difficult for students to understand,"
                + " especially because if A is false and B is false,"
                + " the conclusion remains true. This is also referred"
                + " to as being vacuously true. We refer to A as the"
                + " antecedent of the conditional, and B as the consequent."
                + " An important piece of the right-arrow operator is the"
                + " idea of sufficient and necessary conditions. The antecedent"
                + " is sufficient for the consequent. The consequent is necessary"
                + " for the antecedent.",
                new ArrayList <String> () {{
                    add("1. Suppose A represents the proposition that someone is"
                            + " a bachelor, and B represents the proposition that"
                            + " someone is unmarried. Therefore, (A ⇒ B) reads \"If"
                            + " someone is a bachelor, then they are unmarried\"."
                            + " Since someone cannot be married and a bachelor, it"
                            + " holds true that being unmarried is necessary for"
                            + " being a bachelor (in other words, you cannot be a"
                            + " bachelor if you are married). Since everyone who is"
                            + " a bachelor is unmarried, it makes sense that being a"
                            + " bachelor is sufficient for being unmarried.");
                    add("2. Suppose A is true and B is false. Then (A → B) is false.");
                    add("3. Suppose A is false and B is false. Then (A → B) is true.");
                }}
        );
    }

}