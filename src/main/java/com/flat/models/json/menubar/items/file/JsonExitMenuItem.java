package com.flat.models.json.menubar.items.file;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonExitMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        EXIT,
    }

    private KeyedJsonString exit = new KeyedJsonString(JsonExitMenuItem.class, Keys.EXIT, "Exit");

    public KeyedJsonString getExit() {
        return exit;
    }

    public void setExit(KeyedJsonString exit) {
        this.exit = exit;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(exit);
        }};
    }

}