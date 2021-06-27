package com.flat.models.json;

import com.google.gson.annotations.Expose;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonString {
    @Expose
    private String string;

    public JsonString(String _string) {
        this.string = _string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}