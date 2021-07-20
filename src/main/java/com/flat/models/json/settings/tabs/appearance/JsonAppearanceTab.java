package com.flat.models.json.settings.tabs.appearance;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.settings.tabs.appearance.content.JsonColorPane;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAppearanceTab extends Translatable {

    public enum Keys implements JsonKey {
        APPEARANCE
    }

    private KeyedJsonString appearance = new KeyedJsonString(JsonAppearanceTab.class, Keys.APPEARANCE, "Appearance");
    private JsonColorPane jsonColorPane = new JsonColorPane();

    // Getters for object's attributes.
    public KeyedJsonString getAppearance() {
        return appearance;
    }

    public JsonColorPane getJsonColorPane() {
        return jsonColorPane;
    }

    // Setters for object's attributes.
    public void setAppearance(KeyedJsonString appearance) {
        this.appearance = appearance;
    }

    public void setJsonColorPane(JsonColorPane jsonColorPane) {
        this.jsonColorPane = jsonColorPane;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(appearance);
            addAll(jsonColorPane.toTranslate());
        }};
    }

}