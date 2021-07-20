package com.flat.models.json.base;

/**
 *
 * @author christopherbrantley
 */
public class JsonString {
    private String string;

    public JsonString (String _string) {
        this.string = _string;
    }

    // Getters for object's attributes.
    public String getString() {
        return string;
    }

    // Setters for object's attributes.
    public void setString(String string) {
        this.string = string;
    }

}