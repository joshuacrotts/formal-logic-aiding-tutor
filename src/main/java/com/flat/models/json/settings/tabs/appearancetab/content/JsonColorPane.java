package com.flat.models.json.settings.tabs.appearancetab.content;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonColorPane extends Translatable {
    private JsonString primaryColor = new JsonString("Primary Color:");
    private JsonString secondaryColor = new JsonString("Secondary Color:");
    private JsonString borderColor = new JsonString("Border Color:");

    // Getters for object's attributes.
    public JsonString getPrimaryColor() {
        return primaryColor;
    }

    public JsonString getSecondaryColor() {
        return secondaryColor;
    }

    public JsonString getBorderColor() {
        return borderColor;
    }

    // Setters for object's attributes.
    public void setPrimaryColor(JsonString primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(JsonString secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public void setBorderColor(JsonString borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(primaryColor);
            add(secondaryColor);
            add(borderColor);
        }};
    }

}