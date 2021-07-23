package com.flat.tools.data.json;

import com.flat.controller.Controller;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.data.base.enums.LocalData;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonData {
    private static JsonData instance = null;
    private JsonLanguage[] languages = JsonTools.jsonToObjectList(JsonLanguage.NONE, LocalData.File.LANGUAGE, JsonLanguage[].class);

    private JsonData (JsonLanguage _language) {
        Controller.FX_DATA.getLanguages().setLanguages(languages);
    }

    public static JsonData getInstance (JsonLanguage _language) {
        if (instance == null) {
            instance = new JsonData(_language);
        }
        return instance;
    }

    // Getters for object's attributes.
    public JsonLanguage[] getLanguages() {
        return languages;
    }

    // Setters for object's attributes.
    public void setLanguages(JsonLanguage[] languages) {
        this.languages = languages;
    }

}