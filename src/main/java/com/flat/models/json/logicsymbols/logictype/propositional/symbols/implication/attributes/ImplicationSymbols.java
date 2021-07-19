package com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationSymbols extends Symbols {

    public ImplicationSymbols () {
        super("→",
                new ArrayList <String> () {{
                    add("⇒");
                    add("⊃");
                    add("->");
                    add("→");
                }}
        );
    }

}