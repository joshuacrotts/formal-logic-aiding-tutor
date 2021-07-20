package com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.DoubleTurnstileSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileSymbols extends KeyedSymbols {

    public DoubleTurnstileSymbols () {
        super(
                DoubleTurnstileSymbol.class,
                "⊨",
                new ArrayList <String> () {{
                    add("⊧");
                    add("⊨");
                }}
        );
    }

}