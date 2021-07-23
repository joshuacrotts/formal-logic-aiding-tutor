package com.flat.models.data.logicsymbols.propositional.biconditional;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.models.data.logicsymbols.propositional.biconditional.attributes.BiconditionalAxioms;
import com.flat.models.data.logicsymbols.propositional.biconditional.attributes.BiconditionalSymbols;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbol extends LogicSymbol {

    public BiconditionalSymbol () {
        super(
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.LABEL, "Biconditional"),
                new BiconditionalSymbols(),
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.TOOL_TIP, "Equivalence"),
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.DESCRIPTION, "This is the equivalence button."),
                new KeyedText(BiconditionalSymbol.class, LogicSymbol.Keys.READ_AS, "If and only if; \"iff\"; means the same as"),
                new BiconditionalAxioms()
        );
    }

    public BiconditionalSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}