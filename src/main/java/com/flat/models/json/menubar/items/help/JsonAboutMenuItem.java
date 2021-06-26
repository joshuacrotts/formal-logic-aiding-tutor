package com.flat.models.json.menubar.items.help;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonAboutMenuItem extends Translatable {
    @Expose
    private JsonString about = new JsonString("About");

    public JsonString getAbout() {
        return about;
    }

    public void setAbout(JsonString about) {
        this.about = about;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(about);
        }};
    }

}