package com.flat.models.json.settings.tabs.advance.content.alert;

import com.flat.models.TimeoutManager;
import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonAdvanceAlert extends Translatable {
    private JsonString message = new JsonString("Message");
    private JsonString messageText = new JsonString("Timeout values were updated.");
    private JsonString error = new JsonString("Error");
    private JsonString errorText = new JsonString("Please ensure values are within the range: (" + TimeoutManager.getMinValue() + ", " + TimeoutManager.getMaxValue() + ").");
    private JsonString ok = new JsonString("Ok");

    // Getters for object's attributes.
    public JsonString getMessage() {
        return message;
    }

    public JsonString getMessageText() {
        return messageText;
    }

    public JsonString getError() {
        return error;
    }

    public JsonString getErrorText() {
        return errorText;
    }

    public JsonString getOk() {
        return ok;
    }

    // Setters for object's attributes.
    public void setMessage(JsonString message) {
        this.message = message;
    }

    public void setMessageText(JsonString messageText) {
        this.messageText = messageText;
    }

    public void setError(JsonString error) {
        this.error = error;
    }

    public void setErrorText(JsonString errorText) {
        this.errorText = errorText;
    }

    public void setOk(JsonString ok) {
        this.ok = ok;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString> () {{
            add(message);
            add(messageText);
            add(error);
            add(errorText);
            add(ok);
        }};
    }

}