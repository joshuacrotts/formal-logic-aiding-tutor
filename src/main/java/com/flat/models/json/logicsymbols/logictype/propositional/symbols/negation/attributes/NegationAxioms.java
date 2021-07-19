package com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class NegationAxioms extends Axioms {

    public NegationAxioms () {
        super("The negation operator (~) flips the truth"
                + " value of a proposition A. So, if A is"
                + " true, then ~A is false. Likewise, if ~A"
                + " is false, then ~A is true. The negation"
                + " operator works across any sentence and"
                + " distributes over both symbols and operators.",
                new ArrayList () {{
                    add("1. (~~A ⇔ A)");
                    add("2. ¬(A & B) is equivalent to (¬A ∨ ¬B). The"
                            + " negation operator follows the"
                            + " distributive property from math - we"
                            + " distribute it to everything inside of"
                            + " the parentheses.");
                    add("3. ~(A -> ~B) is equivalent to (A & ~~B), which"
                            + " reduces to (A & B). Note that when we use"
                            + " a negation on an implication (also called"
                            + " a negated implication) sentence, we do not"
                            + " double-negate the antecedent; we reduce it"
                            + " to a proposition minus any negations.");
                }}
        );
    }

}