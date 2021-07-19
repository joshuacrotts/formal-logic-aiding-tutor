package com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes.TurnstileAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes.TurnstileSymbols;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbol extends LogicSymbol {

    public TurnstileSymbol () {
        super("Turnstile",
                new TurnstileSymbols(),
                "Syntactic Entailment",
                "This is the \"proves\" button.",
                "Proves...",
                new TurnstileAxioms()
        );
    }

}