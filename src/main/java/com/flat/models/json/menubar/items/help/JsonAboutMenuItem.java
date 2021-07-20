package com.flat.models.json.menubar.items.help;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAboutMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        ABOUT,
    }

    private KeyedJsonString about = new KeyedJsonString(JsonAboutMenuItem.class, Keys.ABOUT, "About");

    public KeyedJsonString getAbout() {
        return about;
    }

    public void setAbout(KeyedJsonString about) {
        this.about = about;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(about);
        }};
    }

}