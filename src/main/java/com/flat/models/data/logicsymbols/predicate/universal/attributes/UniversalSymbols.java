package com.flat.models.data.logicsymbols.predicate.universal.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;

/**
 *
 * @author christopherbrantley
 */
public class UniversalSymbols extends Symbols {

    public UniversalSymbols () {
        super.setGeneral(new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.GENERAL, "∀"));
        super.setAlternate(new KeyedTextArrayList(
                UniversalSymbol.class,
                LogicSymbol.Keys.ALTERNATE,
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "∀"),
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "()")
        ));
    }

    public UniversalSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}