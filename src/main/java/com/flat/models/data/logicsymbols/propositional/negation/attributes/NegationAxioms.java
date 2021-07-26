package com.flat.models.data.logicsymbols.propositional.negation.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;

/**
 *
 * @author christopherbrantley
 */
public class NegationAxioms extends Axioms {

    public NegationAxioms () {
        super(new KeyedText(NegationSymbol.class, LogicSymbol.Keys.EXPLANATION, "The negation operator (~) flips the truth value of a proposition A. So, if A is true, then ~A is false. Likewise, if ~A is false, then ~A is true. The negation operator works across any sentence and distributes over both symbols and operators."),
                new KeyedTextArrayList(
                        NegationSymbol.class,
                        LogicSymbol.Keys.EXAMPLES,
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. (~~A ⇔ A)"),
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. ¬(A & B) is equivalent to (¬A ∨ ¬B). The negation operator follows the distributive property from math - we distribute it to everything inside of the parentheses."),
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.EXAMPLE_3, "3. ~(A -> ~B) is equivalent to (A & ~~B), which reduces to (A & B). Note that when we use a negation on an implication (also called a negated implication) sentence, we do not double-negate the antecedent; we reduce it to a proposition minus any negations.")
                )
        );
    }

    public NegationAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}