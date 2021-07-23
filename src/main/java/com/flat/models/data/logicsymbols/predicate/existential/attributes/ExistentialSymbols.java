package com.flat.models.data.logicsymbols.predicate.existential.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;

/**
 *
 * @author christopherbrantley
 */
public class ExistentialSymbols extends Symbols {

    public ExistentialSymbols () {
        super.setGeneral(new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.GENERAL, "∃"));
        super.setAlternate(new KeyedTextArrayList(
                new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.ALTERNATE_1, "∃")
        ));
    }

    public ExistentialSymbols (KeyedText _general, KeyedTextArrayList _alternate) {
        super(_general, _alternate);
    }

}