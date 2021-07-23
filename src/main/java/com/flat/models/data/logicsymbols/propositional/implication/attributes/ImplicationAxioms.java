package com.flat.models.data.logicsymbols.propositional.implication.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationAxioms extends Axioms {

    public ImplicationAxioms () {
        super(new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.EXPLANATION, "(A ⇒ B) is false when A is true and B is false, but true otherwise. The implication operator is often difficult for students to understand, especially because if A is false and B is false, the conclusion remains true. This is also referred to as being vacuously true. We refer to A as the antecedent of the conditional, and B as the consequent. An important piece of the right-arrow operator is the idea of sufficient and necessary conditions. The antecedent is sufficient for the consequent. The consequent is necessary for the antecedent."),
                new KeyedTextArrayList(
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. Suppose A represents the proposition that someone is a bachelor, and B represents the proposition that someone is unmarried. Therefore, (A ⇒ B) reads \"If someone is a bachelor, then they are unmarried\". Since someone cannot be married and a bachelor, it holds true that being unmarried is necessary for being a bachelor (in other words, you cannot be a bachelor if you are married). Since everyone who is a bachelor is unmarried, it makes sense that being a bachelor is sufficient for being unmarried."),
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. Suppose A is true and B is false. Then (A → B) is false."),
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.EXAMPLE_3, "3. Suppose A is false and B is false. Then (A → B) is true.")
                ));
    }

    public ImplicationAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}