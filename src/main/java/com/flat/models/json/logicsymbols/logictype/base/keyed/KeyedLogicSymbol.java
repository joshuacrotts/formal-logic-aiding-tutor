package com.flat.models.json.logicsymbols.logictype.base.keyed;

import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
/**
 *
 * @author christopherbrantley
 */
public class KeyedLogicSymbol extends LogicSymbol {

    public enum JsonKeys implements JsonKey {
            LABEL,
            TOOL_TIP,
            DESCRIPTION,
            READ_AS,
        }

    public KeyedLogicSymbol(Class <?> _class, String _label, KeyedSymbols _symbols, String _toolTip, String _description, String _readAs, KeyedAxioms _axioms) {
        super(
                new KeyedJsonString(_class, JsonKeys.LABEL, _label),
                _symbols,
                new KeyedJsonString(_class, JsonKeys.LABEL, _toolTip),
                new KeyedJsonString(_class, JsonKeys.LABEL, _description),
                new KeyedJsonString(_class, JsonKeys.LABEL, _readAs),
                _axioms
        );
    }

}