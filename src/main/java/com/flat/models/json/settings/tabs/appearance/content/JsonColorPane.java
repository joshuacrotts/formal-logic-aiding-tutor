package com.flat.models.json.settings.tabs.appearance.content;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonColorPane extends Translatable {

    public enum Keys implements JsonKey {
        PRIMARY_COLOR,
        SECONDARY_COLOR,
        BORDER_COLOR
    }

    private KeyedJsonString primaryColor = new KeyedJsonString(JsonColorPane.class, Keys.PRIMARY_COLOR, "Primary Color:");
    private KeyedJsonString secondaryColor = new KeyedJsonString(JsonColorPane.class, Keys.SECONDARY_COLOR, "Secondary Color:");
    private KeyedJsonString borderColor = new KeyedJsonString(JsonColorPane.class, Keys.BORDER_COLOR, "Border Color:");

    // Getters for object's attributes.
    public KeyedJsonString getPrimaryColor() {
        return primaryColor;
    }

    // Setters for object's attributes.
    public void setPrimaryColor(KeyedJsonString primaryColor) {
        this.primaryColor = primaryColor;
    }

    public KeyedJsonString getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(KeyedJsonString secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public KeyedJsonString getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(KeyedJsonString borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(primaryColor);
            add(secondaryColor);
            add(borderColor);
        }};
    }

}