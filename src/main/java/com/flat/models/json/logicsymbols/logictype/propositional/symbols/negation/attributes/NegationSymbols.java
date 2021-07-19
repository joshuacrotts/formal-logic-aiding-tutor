package com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbols extends Symbols {

    public NegationSymbols () {
        super("~",
                new ArrayList <String> () {{
                    add("¬");
                    add("!");
                    add("˜");
                    add("~");
                }}
        );
    }

}