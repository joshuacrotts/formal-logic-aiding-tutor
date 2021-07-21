package com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.keyed;

import com.flat.models.json.logicsymbols.logictype.base.attributes.symbols.Symbols;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class KeyedSymbols extends Symbols {
    private final Class<?> key;

    public KeyedSymbols(Class <?> _key, String _general, ArrayList<String> _alternate) {
        super(_general, _alternate);
        this.key = _key;
    }

    // Getters for object's attributes.
    public Class<?> getKey() {
        return key;
    }

}