package com.flat.models.json.logicsymbols.logictype.base.keyed;

import com.flat.controller.Controller;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed.KeyedAxioms;
import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed.KeyedSymbols;
import com.flat.view.data.json.MappedLogicSymbols;
import java.io.Serializable;
/**
 *
 * @author christopherbrantley
 */
public class KeyedLogicSymbol extends LogicSymbol implements Serializable {
    private Class <?> key1;
    private Type key2;

    public enum Type implements JsonKey {
        PROPOSITIONAL,
        PREDICATE,
    }

    public enum Keys implements JsonKey {
            LABEL,
            TOOL_TIP,
            DESCRIPTION,
            READ_AS,
        }

    public KeyedLogicSymbol (Class <?> _key1, Type _key2) {
        super();
        this.key1 = _key1;
        this.key2 = _key2;
    }

    public KeyedLogicSymbol(Class <?> _class, Type _type, String _label, KeyedSymbols _symbols, String _toolTip, String _description, String _readAs, KeyedAxioms _axioms) {
        super(new KeyedJsonString(_class, Keys.LABEL, _label),
                _symbols,
                new KeyedJsonString(_class, Keys.TOOL_TIP, _toolTip),
                new KeyedJsonString(_class, Keys.DESCRIPTION, _description),
                new KeyedJsonString(_class, Keys.READ_AS, _readAs),
                _axioms
        );
        this.updateMap();
    }

    public final void updateMap () {
        //Controller.getKEYED_LOGIC_SYMBOLS().putValue(this.key1, this.key2, this);
    }

}