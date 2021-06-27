package com.flat.models.json.menubar.items.file;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonExitMenuItem extends Translatable {
    private JsonString exit = new JsonString("Exit");

    public JsonString getExit() {
        return exit;
    }

    public void setExit(JsonString exit) {
        this.exit = exit;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(exit);
        }};
    }

}