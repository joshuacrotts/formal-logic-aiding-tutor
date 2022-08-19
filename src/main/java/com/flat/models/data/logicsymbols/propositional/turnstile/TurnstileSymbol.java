package com.flat.models.data.logicsymbols.propositional.turnstile;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.turnstile.attributes.TurnstileAxioms;
import com.flat.models.data.logicsymbols.propositional.turnstile.attributes.TurnstileSymbols;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbol extends LogicSymbol {

    public TurnstileSymbol () {
        super(
                new KeyedText(TurnstileSymbol.class, Keys.LABEL, "Turnstile"),
                new TurnstileSymbols(),
                new KeyedText(TurnstileSymbol.class, Keys.TOOL_TIP, "Syntactic entailment"),
                new KeyedText(TurnstileSymbol.class, Keys.DESCRIPTION, "This is the \\\"proves\\\" button."),
                new KeyedText(TurnstileSymbol.class, Keys.READ_AS, "Proves..."),
                new TurnstileAxioms()
        );
    }

    public TurnstileSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}