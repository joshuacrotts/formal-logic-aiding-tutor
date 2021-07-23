package com.flat.models.data.logicsymbols.propositional.conjunction.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.conjunction.ConjunctionSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionSymbols extends Symbols {

    public ConjunctionSymbols () {
        super(
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.GENERAL, "∧"),
                new KeyedTextArrayList(
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "&"),
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_2, "·"),
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_3, "^"),
                        new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_4, "∧")
                )
        );
    }

    public ConjunctionSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}