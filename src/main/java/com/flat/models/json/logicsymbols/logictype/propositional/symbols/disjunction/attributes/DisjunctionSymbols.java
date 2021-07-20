package com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.attributes;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.DisjunctionSymbol;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbols extends KeyedSymbols {

    public DisjunctionSymbols () {
        super(
                DisjunctionSymbol.class,
                "∨",
                new ArrayList <String> () {{
                    add("|");
                    add("+");
                    add("||");
                    add("∨");
                }}
        );
    }

}