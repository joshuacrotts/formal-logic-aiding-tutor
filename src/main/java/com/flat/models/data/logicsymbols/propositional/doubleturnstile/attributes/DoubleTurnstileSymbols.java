package com.flat.models.data.logicsymbols.propositional.doubleturnstile.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileSymbols extends Symbols {

    public DoubleTurnstileSymbols () {
        super(new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.GENERAL, "⊨"),
                new KeyedTextArrayList(
                        DoubleTurnstileSymbol.class,
                        LogicSymbol.Keys.ALTERNATE,
                        new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "⊧"),
                        new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "⊨")
                ));
    }

    public DoubleTurnstileSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}