package com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.BiconditionalSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbols extends KeyedSymbols {

    public BiconditionalSymbols () {
        super(
                BiconditionalSymbol.class,
                "↔",
                new ArrayList <String> () {{
                    add("⇔");
                    add("≡");
                    add("<->");
                    add("↔");
                }}
        );
    }

}