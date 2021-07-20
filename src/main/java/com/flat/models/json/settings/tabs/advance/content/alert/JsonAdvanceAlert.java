package com.flat.models.json.settings.tabs.advance.content.alert;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAdvanceAlert extends Translatable {

    public enum Keys implements JsonKey {
        MESSAGE,
        MESSAGE_TEXT,
        ERROR,
        ERROR_TEXT,
        OK
    }

    private KeyedJsonString message = new KeyedJsonString(JsonAdvanceAlert.class, Keys.MESSAGE, "Message");
    private KeyedJsonString messageText = new KeyedJsonString(JsonAdvanceAlert.class, Keys.MESSAGE_TEXT, "Timeout values were updated.");
    private KeyedJsonString error = new KeyedJsonString(JsonAdvanceAlert.class, Keys.ERROR, "Error");
    private KeyedJsonString errorText = new KeyedJsonString(JsonAdvanceAlert.class, Keys.ERROR_TEXT, "Please ensure values are within the specified range.");
    private KeyedJsonString ok = new KeyedJsonString(JsonAdvanceAlert.class, Keys.OK, "Ok");

    // Getters for object's attributes.
    public KeyedJsonString getMessage() {
        return message;
    }

    public KeyedJsonString getMessageText() {
        return messageText;
    }

    public KeyedJsonString getError() {
        return error;
    }

    public KeyedJsonString getErrorText() {
        return errorText;
    }

    public KeyedJsonString getOk() {
        return ok;
    }

    // Setters for object's attributes.
    public void setMessage(KeyedJsonString message) {
        this.message = message;
    }

    public void setMessageText(KeyedJsonString messageText) {
        this.messageText = messageText;
    }

    public void setError(KeyedJsonString error) {
        this.error = error;
    }

    public void setErrorText(KeyedJsonString errorText) {
        this.errorText = errorText;
    }

    public void setOk(KeyedJsonString ok) {
        this.ok = ok;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(message);
            add(messageText);
            add(error);
            add(errorText);
            add(ok);
        }};
    }

}