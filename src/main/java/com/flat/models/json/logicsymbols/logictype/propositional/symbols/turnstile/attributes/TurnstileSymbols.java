package com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class TurnstileSymbols extends Symbols {

    public TurnstileSymbols () {
        super("⊢",
                new ArrayList <String> () {{
                    add("∴");
                    add("⊢");
                }}
        );
    }

}