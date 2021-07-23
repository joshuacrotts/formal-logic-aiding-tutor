package com.flat.models.data.logicsymbols.propositional.turnstile.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbols extends Symbols {

    public TurnstileSymbols () {
        super(new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.GENERAL, "⊢"),
                new KeyedTextArrayList(
                        new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "∴"),
                        new KeyedText(TurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "⊢")
                )
        );
    }

    public TurnstileSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}