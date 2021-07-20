package com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.TurnstileSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbols extends KeyedSymbols {

    public TurnstileSymbols () {
        super(
                TurnstileSymbol.class,
                "⊢",
                new ArrayList <String> () {{
                    add("∴");
                    add("⊢");
                }}
        );
    }

}