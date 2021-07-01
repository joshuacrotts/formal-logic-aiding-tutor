package com.flat.models.json.settings.tabs.language;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonLanguageTab extends Translatable {
    private JsonString language = new JsonString("Language");

    // Getters for object's attributes.
    public JsonString getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setLanguage(JsonString language) {
        this.language = language;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(language);
        }};
    }

}