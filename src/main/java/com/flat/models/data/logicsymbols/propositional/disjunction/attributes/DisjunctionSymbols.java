package com.flat.models.data.logicsymbols.propositional.disjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbols extends Symbols {

    public DisjunctionSymbols () {
        super(new KeyedText(DisjunctionSymbols.class, LogicSymbol.Keys.GENERAL, "∨"),
                new KeyedTextArrayList(
                        new KeyedText(DisjunctionSymbols.class, LogicSymbol.Keys.EXAMPLE_1, "|"),
                        new KeyedText(DisjunctionSymbols.class, LogicSymbol.Keys.EXAMPLE_2, "+"),
                        new KeyedText(DisjunctionSymbols.class, LogicSymbol.Keys.EXAMPLE_3, "||"),
                        new KeyedText(DisjunctionSymbols.class, LogicSymbol.Keys.EXAMPLE_4, "∨")
                )
        );
    }

    public DisjunctionSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}