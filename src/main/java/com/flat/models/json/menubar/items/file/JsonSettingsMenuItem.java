package com.flat.models.json.menubar.items.file;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonSettingsMenuItem extends Translatable {
    @Expose
    private JsonString settings = new JsonString("Settings");

    public JsonString getSettings() {
        return settings;
    }

    public void setSettings(JsonString settings) {
        this.settings = settings;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(settings);
        }};
    }

}