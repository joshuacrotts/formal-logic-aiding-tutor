package com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionSymbols extends Symbols {

    public ExclusiveDisjunctionSymbols () {
        super(new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.GENERAL, "⊕"),
                new KeyedTextArrayList(
                        ExclusiveDisjunctionSymbol.class,
                        LogicSymbol.Keys.ALTERNATE,
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "⊻"),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "≢"),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "⩒"),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "↮"),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_5, "⩛"),
                        new KeyedText(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_6, "⊕")
                )
        );
    }

    public ExclusiveDisjunctionSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}