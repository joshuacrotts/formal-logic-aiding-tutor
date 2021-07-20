package com.flat.models.json.logicsymbols.logictype.base;

import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.Axioms;
import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.Symbols;
import com.flat.models.json.base.keyed.KeyedJsonString;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalSymbol extends LogicSymbol {

    public PropositionalSymbol(KeyedJsonString _label, Symbols _symbols, KeyedJsonString _toolTip, KeyedJsonString _description, KeyedJsonString _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}