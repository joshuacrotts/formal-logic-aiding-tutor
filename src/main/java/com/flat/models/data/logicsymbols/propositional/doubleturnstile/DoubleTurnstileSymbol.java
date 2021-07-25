package com.flat.models.data.logicsymbols.propositional.doubleturnstile;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.attributes.DoubleTurnstileAxioms;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.attributes.DoubleTurnstileSymbols;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileSymbol extends LogicSymbol {

    public DoubleTurnstileSymbol () {
        super(
                new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.LABEL, "Double Turnstile"),
                new DoubleTurnstileSymbols(),
                new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Semantic entailment"),
                new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the \\\"models\\\" button."),
                new KeyedText(DoubleTurnstileSymbol.class, LogicSymbol.Keys.READ_AS, "Models..."),
                new DoubleTurnstileAxioms()
        );
    }

    public DoubleTurnstileSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}