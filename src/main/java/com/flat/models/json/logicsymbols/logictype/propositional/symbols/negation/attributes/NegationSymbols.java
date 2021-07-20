package com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.NegationSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbols extends KeyedSymbols {

    public NegationSymbols () {
        super(
                NegationSymbol.class,
                "~",
                new ArrayList <String> () {{
                    add("¬");
                    add("!");
                    add("˜");
                    add("~");
                }}
        );
    }

}