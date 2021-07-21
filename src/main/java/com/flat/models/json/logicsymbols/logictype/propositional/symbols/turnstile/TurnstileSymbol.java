package com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes.TurnstileAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes.TurnstileSymbols;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbol extends KeyedLogicSymbol {

    public TurnstileSymbol () {
        super(
                KeyedLogicSymbol.class,
                Type.PROPOSITIONAL,
                "Turnstile",
                new TurnstileSymbols(),
                "Syntactic Entailment",
                "This is the \"proves\" button.",
                "Proves...",
                new TurnstileAxioms()
        );
    }

}