package com.flat.models.json.settings.tabs.appearance;

import com.flat.models.json.JsonString;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
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

    public JsonColorPane getJsonColorPane() {
        return jsonColorPane;
    }

    // Setters for object's attributes.
    public void setAppearance(JsonString appearance) {
        this.appearance = appearance;
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