package com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionAxioms extends Axioms {

    public ExclusiveDisjunctionAxioms () {
        super(new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.EXPLANATION, "The statement (A ⊕ B) is true when either A or B are true, but not both are true."),
                new KeyedTextArrayList(
                        ExclusiveDisjunctionSymbol.class,
                        LogicSymbol.Keys.EXAMPLES,
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_1, "1. A common example of the exclusive or operator comes up when talking about exclusivity among events. In other words, if we have two propositions P and Q, then either P can be true or Q can be true. However, P and Q cannot be true. Also, P and Q cannot be false."),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_2, "2. Suppose A is true and B is false. Then (A ⊕ B) is true."),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.EXAMPLE_3, "3. Suppose A is true and B is false. Then ((A → B) ⊕ (B → A)) is true. (A → B) is false, and (B → A) is true. Thus, the operands are different which results in true.")
                )
        );
    }

    public ExclusiveDisjunctionAxioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        super(_explanation, _examples);
    }

}