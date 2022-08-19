package com.flat.models.data.settings.tabs.advanced.content.alert;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class AdvancedAlert extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        MESSAGE,
        MESSAGE_TEXT,
        ERROR,
        ERROR_TEXT,
        OK
    }

    private KeyedText message = new KeyedText(AdvancedAlert.class, Keys.MESSAGE, "Message");
    private KeyedText messageText = new KeyedText(AdvancedAlert.class, Keys.MESSAGE_TEXT, "Timeout values were updated.");
    private KeyedText error = new KeyedText(AdvancedAlert.class, Keys.ERROR, "Error");
    private KeyedText errorText = new KeyedText(AdvancedAlert.class, Keys.ERROR_TEXT, "Please ensure values are within the specified range.");
    private KeyedText ok = new KeyedText(AdvancedAlert.class, Keys.OK, "Ok");

    public AdvancedAlert () {
    }

    // Getters for object's attributes.
    public KeyedText getMessage() {
        return message;
    }

    public KeyedText getMessageText() {
        return messageText;
    }

    public KeyedText getError() {
        return error;
    }

    public KeyedText getErrorText() {
        return errorText;
    }

    public KeyedText getOk() {
        return ok;
    }

    // Setters for object's attributes.
    public void setMessage(KeyedText message) {
        this.message = message;
    }

    public void setMessageText(KeyedText messageText) {
        this.messageText = messageText;
    }

    public void setError(KeyedText error) {
        this.error = error;
    }

    public void setErrorText(KeyedText errorText) {
        this.errorText = errorText;
    }

    public void setOk(KeyedText ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "AdvancedAlert{" + "message=" + message + ", messageText=" + messageText + ", error=" + error + ", errorText=" + errorText + ", ok=" + ok + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.message);
            os.writeObject(this.messageText);
            os.writeObject(this.error);
            os.writeObject(this.errorText);
            os.writeObject(this.ok);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.message = (KeyedText) is.readObject();
            this.messageText = (KeyedText) is.readObject();
            this.error = (KeyedText) is.readObject();
            this.errorText = (KeyedText) is.readObject();
            this.ok = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(message);
            add(messageText);
            add(error);
            add(errorText);
            add(ok);
        }};
    }

}