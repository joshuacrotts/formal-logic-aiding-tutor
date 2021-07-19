package com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbols extends Symbols {

    public DisjunctionSymbols () {
        super("∨",
                new ArrayList <String> () {{
                    add("|");
                    add("+");
                    add("||");
                    add("∨");
                }}
        );
    }

}