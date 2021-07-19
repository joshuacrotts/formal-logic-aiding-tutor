package com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbols extends Symbols {

    public BiconditionalSymbols () {
        super("↔",
                new ArrayList <String> () {{
                    add("⇔");
                    add("≡");
                    add("<->");
                    add("↔");
                }}
        );
    }

}