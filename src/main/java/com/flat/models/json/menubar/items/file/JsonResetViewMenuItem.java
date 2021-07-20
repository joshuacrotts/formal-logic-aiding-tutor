package com.flat.models.json.menubar.items.file;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonResetViewMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        RESET,
    }

    private KeyedJsonString reset = new KeyedJsonString(JsonResetViewMenuItem.class, Keys.RESET, "Reset");

    public KeyedJsonString getReset() {
        return reset;
    }

    public void setReset(KeyedJsonString reset) {
        this.reset = reset;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList< JsonString>() {{
            add(reset);
        }};
    }

}