package com.flat.models.json.logicsymbols.logictype.predicate;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.ExistentialSymbol;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.universal.UniversalSymbol;
import com.flat.tools.translation.base.Translatable;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateSymbols extends Translatable implements Serializable {

    public enum Keys implements JsonKey  {
        LABEL,
    }

    private KeyedJsonString predicate = new KeyedJsonString(PredicateSymbols.class, Keys.LABEL, "Predicate");
    private ExistentialSymbol existential = new ExistentialSymbol();
    private UniversalSymbol universal = new UniversalSymbol();

    public PredicateSymbols () {
    }

    // Getters for object's attributes.
    public ExistentialSymbol getExistential() {
        return existential;
    }

    public UniversalSymbol getUniversal() {
        return universal;
    }

    // Setters for object's attributes.
    public void setExistential(ExistentialSymbol existential) {
        this.existential = existential;
    }

    public void setUniversal(UniversalSymbol universal) {
        this.universal = universal;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            addAll(existential.toTranslate());
            addAll(universal.toTranslate());
        }};
    }

}