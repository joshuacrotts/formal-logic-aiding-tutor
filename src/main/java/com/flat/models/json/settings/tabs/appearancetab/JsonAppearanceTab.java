package com.flat.models.json.settings.tabs.appearancetab;

import com.flat.models.json.JsonString;
import com.flat.models.json.settings.tabs.appearancetab.content.JsonColorPane;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAppearanceTab extends Translatable {
    private JsonString appearance = new JsonString("Appearance");
    private JsonColorPane jsonColorPane = new JsonColorPane();

    // Getters for object's attributes.
    public JsonString getAppearance() {
        return appearance;
    }

    // Setters for object's attributes.
    public void setAppearance(JsonString appearance) {
        this.appearance = appearance;
    }

    public JsonColorPane getJsonColorPane() {
        return jsonColorPane;
    }

    public void setJsonColorPane(JsonColorPane jsonColorPane) {
        this.jsonColorPane = jsonColorPane;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(appearance);
            addAll(jsonColorPane.toTranslate());
        }};
    }

}