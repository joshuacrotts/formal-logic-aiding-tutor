package com.flat.models.data.logicsymbols.predicate.universal;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.predicate.universal.attributes.UniversalAxioms;
import com.flat.models.data.logicsymbols.predicate.universal.attributes.UniversalSymbols;

/**
 *
 * @author christopherbrantley
 */
public class UniversalSymbol extends LogicSymbol {

    public UniversalSymbol () {
        super(
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.LABEL, "Universal"),
                new UniversalSymbols(),
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Universal Quantification"),
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the universal quantification button."),
                new KeyedText(UniversalSymbol.class, LogicSymbol.Keys.READ_AS, "For all; For any; For each; All; Every"),
                new UniversalAxioms()
        );
    }

    public UniversalSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}