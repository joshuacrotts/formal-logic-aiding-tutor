package com.flat.models.json.logicsymbols.logictype.base;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import com.flat.models.json.JsonString;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalSymbol extends LogicSymbol {

    public PropositionalSymbol(JsonString _label, Symbols _symbols, JsonString _toolTip, JsonString _description, JsonString _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}