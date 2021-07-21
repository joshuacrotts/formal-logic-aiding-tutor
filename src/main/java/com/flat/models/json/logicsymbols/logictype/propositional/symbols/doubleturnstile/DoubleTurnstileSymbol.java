package com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.attributes.DoubleTurnstileAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.attributes.DoubleTurnstileSymbols;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileSymbol extends KeyedLogicSymbol {

    public DoubleTurnstileSymbol () {
        super(
                DoubleTurnstileSymbol.class,
                Type.PROPOSITIONAL,
                "Double Turnstile",
                new DoubleTurnstileSymbols(),
                "Semantic Entailment",
                "This is the \"models\" button.",
                "Models...",
                new DoubleTurnstileAxioms()
        );
    }

}