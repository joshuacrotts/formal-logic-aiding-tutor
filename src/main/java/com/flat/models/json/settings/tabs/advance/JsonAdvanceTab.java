package com.flat.models.json.settings.tabs.advance;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.settings.tabs.advance.content.JsonAdvancePane;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAdvanceTab extends Translatable {

    public enum Keys implements JsonKey {
        ADVANCE
    }

    private KeyedJsonString advance = new KeyedJsonString(JsonAdvanceTab.class, Keys.ADVANCE, "Advance");
    private JsonAdvancePane advancePane = new JsonAdvancePane();

    // Getters for object's attributes.
    public KeyedJsonString getAdvance() {
        return advance;
    }

    public JsonAdvancePane getAdvancePane() {
        return advancePane;
    }

    // Setters for object's attributes.
    public void setAdvance(KeyedJsonString advance) {
        this.advance = advance;
    }

    public void setAdvancePane(JsonAdvancePane advancePane) {
        this.advancePane = advancePane;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(advance);
            addAll(advancePane.toTranslate());
        }};
    }

}