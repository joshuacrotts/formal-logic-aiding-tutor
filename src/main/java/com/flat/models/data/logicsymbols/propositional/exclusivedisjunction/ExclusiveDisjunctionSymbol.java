package com.flat.models.data.logicsymbols.propositional.exclusivedisjunction;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.attributes.ExclusiveDisjunctionAxioms;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.attributes.ExclusiveDisjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ExclusiveDisjunctionSymbol extends LogicSymbol {

    public ExclusiveDisjunctionSymbol () {
        super(
                new KeyedText(ExclusiveDisjunctionSymbol.class, Keys.LABEL, "Exclusive Disjunction"),
                new ExclusiveDisjunctionSymbols(),
                new KeyedText(ExclusiveDisjunctionSymbol.class, Keys.TOOL_TIP, "Exclusive Disjunction"),
                new KeyedText(ExclusiveDisjunctionSymbol.class, Keys.DESCRIPTION, "This is the exclusive or button."),
                new KeyedText(ExclusiveDisjunctionSymbol.class, Keys.READ_AS, "Either... or; xor"),
                new ExclusiveDisjunctionAxioms()
        );
    }

    public ExclusiveDisjunctionSymbol(KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}