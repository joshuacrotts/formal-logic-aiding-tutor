package com.flat.models.data.logicsymbols.propositional.negation.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbols extends Symbols {

    public NegationSymbols () {
        super(new KeyedText(NegationSymbol.class, LogicSymbol.Keys.GENERAL, "~"),
                new KeyedTextArrayList(
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "¬"),
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "!"),
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "˜"),
                        new KeyedText(NegationSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "~")
                )
        );
    }

    public NegationSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}