package com.flat.models.data.logicsymbols.propositional.negation;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.negation.attributes.NegationAxioms;
import com.flat.models.data.logicsymbols.propositional.negation.attributes.NegationSymbols;

/**
 *
 * @author christopherbrantley
 */
public class NegationSymbol extends LogicSymbol {

    public NegationSymbol () {
        super(
                new KeyedText(NegationSymbol.class, LogicSymbol.Keys.LABEL, "Negation"),
                new NegationSymbols(),
                new KeyedText(NegationSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Negation"),
                new KeyedText(NegationSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the negation button."),
                new KeyedText(NegationSymbol.class, LogicSymbol.Keys.READ_AS, "Not"),
                new NegationAxioms()
        );
    }

    public NegationSymbol(KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}