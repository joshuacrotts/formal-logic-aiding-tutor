package com.flat.models.data.base.text;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author christopherbrantley
 */
public class KeyedTextArrayList extends ArrayList <KeyedText> implements Serializable {

    public KeyedTextArrayList () {
    }

    public KeyedTextArrayList (KeyedText... _text) {
        this.addAll(Arrays.asList(_text));
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
            for (int i = is.readInt() - 1; i >= 0; i--)
                this.add((KeyedText)is.readObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}