package com.flat.models.data.logicsymbols.propositional.implication;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.implication.attributes.ImplicationAxioms;
import com.flat.models.data.logicsymbols.propositional.implication.attributes.ImplicationSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ImplicationSymbol extends LogicSymbol {

    public ImplicationSymbol () {
        super(
                new KeyedText(ImplicationSymbol.class, Keys.LABEL, "Implication"),
                new ImplicationSymbols(),
                new KeyedText(ImplicationSymbol.class, Keys.TOOL_TIP, "Implication"),
                new KeyedText(ImplicationSymbol.class, Keys.DESCRIPTION, "This is the implication button."),
                new KeyedText(ImplicationSymbol.class, Keys.READ_AS, "implies; if ... then"),
                new ImplicationAxioms()
        );
    }

    public ImplicationSymbol(KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}