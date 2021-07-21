package com.flat.view.data.json;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.Symbols;
import java.util.HashMap;

/**
 *
 * @author christopherbrantley
 */
public class KeyedSymbol {
    private final HashMap <Class <?>, Symbols> symbols = new HashMap();

    public KeyedSymbol () {
    }

    // Getters for object's attibutes.
    public HashMap<Class<?>, Symbols> getSymbols () {
        return this.symbols;
    }

    public Symbols getValue (Class<?> _key) {
        return this.symbols.get(_key);
    }

    public void putValue (Class <?> _key, Symbols _value) {
        this.symbols.put(_key, _value);
    }

}