package com.flat.models.json.settings.tabs.advance;

import com.flat.models.json.JsonString;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAdvanceTab extends Translatable {
    private JsonString advance = new JsonString("Advance");
    private JsonAdvancePane advancePane = new JsonAdvancePane();

    // Getters for object's attributes.
    public JsonString getAdvance() {
        return advance;
    }

    public JsonAdvancePane getAdvancePane() {
        return advancePane;
    }

    // Setters for object's attributes.
    public void setAdvance(JsonString advance) {
        this.advance = advance;
    }

    public void setAdvancePane(JsonAdvancePane advancePane) {
        this.advancePane = advancePane;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString> () {{
            add(advance);
            addAll(advancePane.toTranslate());
        }};
    }

}