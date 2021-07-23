package com.flat.models.data.logicsymbols.propositional.implication.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationSymbols extends Symbols {

    public ImplicationSymbols () {
        super(
                new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.GENERAL, "→"),
                new KeyedTextArrayList(
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "⇒"),
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "\"⊃\""),
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "->"),
                        new KeyedText(ImplicationSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "→")
                )
        );
    }

    public ImplicationSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}