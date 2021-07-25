package com.flat.models.data.logicsymbols.propositional.disjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbols extends Symbols {

    public DisjunctionSymbols () {
        super(new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.GENERAL, "∨"),
                new KeyedTextArrayList(
                        DisjunctionSymbol.class,
                        LogicSymbol.Keys.ALTERNATE,
                        new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "|"),
                        new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "+"),
                        new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "||"),
                        new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "∨")
                )
        );
    }

    public DisjunctionSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}