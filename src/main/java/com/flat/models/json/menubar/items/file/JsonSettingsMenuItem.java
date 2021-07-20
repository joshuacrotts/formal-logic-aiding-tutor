package com.flat.models.json.menubar.items.file;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonSettingsMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        SETTINGS,
    }

    private KeyedJsonString settings = new KeyedJsonString(JsonSettingsMenuItem.class, Keys.SETTINGS, "Settings");

    public KeyedJsonString getSettings() {
        return settings;
    }

    public void setSettings(KeyedJsonString settings) {
        this.settings = settings;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(settings);
        }};
    }

}