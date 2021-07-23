package com.flat.models.data.logicsymbols.predicate.existential;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.predicate.existential.attributes.ExistentialAxioms;
import com.flat.models.data.logicsymbols.predicate.existential.attributes.ExistentialSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ExistentialSymbol extends LogicSymbol {

    public ExistentialSymbol () {
        super(
                new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.LABEL, "Universal"),
                new ExistentialSymbols(),
                new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Existential Quantification"),
                new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the existential quantification button."),
                new KeyedText(ExistentialSymbol.class, LogicSymbol.Keys.READ_AS, "There exists; Some; Many; At least one"),
                new ExistentialAxioms()
        );
    }

    public ExistentialSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}