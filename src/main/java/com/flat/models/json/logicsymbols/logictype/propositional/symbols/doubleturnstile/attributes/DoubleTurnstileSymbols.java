package com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DoubleTurnstileSymbols extends Symbols {

    public DoubleTurnstileSymbols () {
        super("⊨",
                new ArrayList <String> () {{
                    add("⊧");
                    add("⊨");
                }}
        );
    }

}