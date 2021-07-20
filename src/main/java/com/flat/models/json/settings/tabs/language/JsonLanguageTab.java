package com.flat.models.json.settings.tabs.language;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonLanguageTab extends Translatable {

    public enum Keys implements JsonKey {
        LANGUAGE
    }

    private KeyedJsonString language = new KeyedJsonString(JsonLanguageTab.class, Keys.LANGUAGE, "Language");

    // Getters for object's attributes.
    public KeyedJsonString getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setLanguage(KeyedJsonString language) {
        this.language = language;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(language);
        }};
    }

}