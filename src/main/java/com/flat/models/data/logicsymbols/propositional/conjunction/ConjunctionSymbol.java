package com.flat.models.data.logicsymbols.propositional.conjunction;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.conjunction.attributes.ConjunctionAxioms;
import com.flat.models.data.logicsymbols.propositional.conjunction.attributes.ConjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class ConjunctionSymbol extends LogicSymbol {

    public ConjunctionSymbol () {
        super(
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.LABEL, "Conjunction"),
                new ConjunctionSymbols(),
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Conjunction"),
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the conjunction button."),
                new KeyedText(ConjunctionSymbol.class, LogicSymbol.Keys.READ_AS, "And"),
                new ConjunctionAxioms()
        );
    }

    public ConjunctionSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}