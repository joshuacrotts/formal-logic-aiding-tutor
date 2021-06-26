package com.flat.models.json.menubar.items.file;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonResetViewMenuItem extends Translatable {
    @Expose
    private JsonString reset = new JsonString("Reset");

    public JsonString getReset() {
        return reset;
    }

    public void setReset(JsonString reset) {
        this.reset = reset;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
       return new LinkedList<JsonString>(){{
           add(reset);
       }}; 
    }

}