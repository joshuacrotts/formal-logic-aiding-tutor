package com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.keyed;

import com.flat.controller.Controller;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.logicsymbols.logictype.base.attributes.axioms.Axioms;
import java.util.ArrayList;

/**
 *
 * @author christopherbrantley
 */
public class KeyedAxioms extends Axioms {
    private final Class<?> key;

    public enum Keys implements JsonKey {
        EXAMPLE,
        EXPLANATIONS
    }

    public KeyedAxioms(Class<?> _key, String _explanation, ArrayList <String> _examples) {
        super.setExplanation(new KeyedJsonString(_key, Keys.EXAMPLE, _explanation));
        _examples.forEach(example -> {
            super.getExamples().add(new KeyedJsonString(_key, Keys.EXPLANATIONS, example));
        });
        this.key = _key;
    }

    // Getters for object's attributes.
    public Class<?> getKey() {
        return key;
    }

}