package com.flat.models.data.base.text;

import com.flat.controller.Controller;
import com.flat.models.data.base.text.key.KeyBase;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author christopherbrantley
 */
public class KeyedTextArrayList extends SimpleListProperty <KeyedText> implements Serializable {
    private Class key1;
    private KeyBase key2;

    public KeyedTextArrayList () {
        super(FXCollections.observableArrayList());
    }

    public KeyedTextArrayList (Class _key1, KeyBase _key2, KeyedText... _text) {
        this();
        this.key1 = _key1;
        this.key2 = _key2;
        super.addAll(Arrays.asList(_text));
        this.addToMap();
    }

    public boolean isMapped () {
        return Controller.MAPPED_TEXT_ARRAY.getValue(this.key1, this.key2) != null;
    }

    private void addToMap () {
        if (!this.isMapped())
            Controller.MAPPED_TEXT_ARRAY.putValue(this.key1, this.key2, this);
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeInt(this.size());
            for (KeyedText example: this) {
                os.writeObject(example);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            super.set(FXCollections.observableArrayList());
            for (int i = is.readInt() - 1; i >= 0; i--)
                super.add((KeyedText)is.readObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}