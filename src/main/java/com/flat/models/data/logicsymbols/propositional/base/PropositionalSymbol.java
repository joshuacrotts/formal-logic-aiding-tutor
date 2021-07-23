package com.flat.models.data.logicsymbols.propositional.base;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;

/**
 *
 * @author christopherbrantley
 */
public class PropositionalSymbol extends LogicSymbol {

    public PropositionalSymbol(KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}