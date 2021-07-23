package com.flat.models.data.logicsymbols.propositional.disjunction;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.disjunction.attributes.DisjunctionAxioms;
import com.flat.models.data.logicsymbols.propositional.disjunction.attributes.DisjunctionSymbols;

/**
 *
 * @author christopherbrantley
 */
public class DisjunctionSymbol extends LogicSymbol {

    public DisjunctionSymbol () {
        super(
                new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.LABEL, "Disjunction"),
                new DisjunctionSymbols(),
                new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Disjunction"),
                new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the disjunction button."),
                new KeyedText(DisjunctionSymbol.class, LogicSymbol.Keys.READ_AS, "Or"),
                new DisjunctionAxioms()
        );
    }

    public DisjunctionSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}