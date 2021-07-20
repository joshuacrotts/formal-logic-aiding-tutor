package com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.ImplicationSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationSymbols extends KeyedSymbols {

    public ImplicationSymbols () {
        super(
                ImplicationSymbol.class,
                "→",
                new ArrayList <String> () {{
                    add("⇒");
                    add("⊃");
                    add("->");
                    add("→");
                }}
        );
    }

}