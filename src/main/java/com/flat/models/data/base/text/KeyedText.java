package com.flat.models.data.base.text;

import com.flat.controller.Controller;
import com.flat.models.data.base.text.key.KeyBase;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class KeyedText extends TranslatableText implements Serializable {
    private Class key1;
    private KeyBase key2;

    public KeyedText () {
    }

    public KeyedText (Class _key1, KeyBase _key2, String _text) {
        super(_text);
        this.key1 = _key1;
        this.key2 = _key2;
        this.addToMap();
    }

    public boolean isMapped () {
        return Controller.getMAPPED_TEXT().getValue(this.key1, this.key2) != null;
    }

    private void addToMap () {
        if (this.isMapped()) {
            Controller.getMAPPED_TEXT().getValue(this.key1, this.key2).textProperty().bind(super.textProperty());
            Controller.getMAPPED_TEXT().getValue(this.key1, this.key2).fontProperty().bind(super.fontProperty());
        }
        else
            Controller.getMAPPED_TEXT().putValue(this.key1, this.key2, this);
    }

    @Override
    public String toString() {
        return "KeyedText{" + "key1=" + this.key1 + ", key2=" + this.key2 + "\n" + super.toString() + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeObject(this.key1);
            os.writeObject(this.key2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            is.defaultReadObject();
            this.key1 = (Class)is.readObject();
            this.key2 = (KeyBase)is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}