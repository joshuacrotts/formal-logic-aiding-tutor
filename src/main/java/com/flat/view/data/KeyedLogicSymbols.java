package com.flat.view.data;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import java.util.HashMap;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class KeyedLogicSymbols {
    private final HashMap <Class <?>, LogicSymbol> symbols = new HashMap();

    public KeyedLogicSymbols () {
    }

    // Getters for object's attibutes.
    public HashMap<Class <?>, LogicSymbol> getSymbols () {
        return this.symbols;
    }

    public LogicSymbol getValue (Class<?> _key) {
        return this.symbols.get(_key);
    }

    public void putValue (Class <?> _key, LogicSymbol _value) {
        this.symbols.put(_key, _value);
    }

}