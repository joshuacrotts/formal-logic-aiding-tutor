package com.flat.models.data.logicsymbols.base.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Symbols extends Translatable implements Serializable {
    private KeyedText general;
    private KeyedTextArrayList alternate = new KeyedTextArrayList();

    public Symbols () {
    }

    public Symbols (KeyedText _general, KeyedTextArrayList _alternate) {
        this.general = _general;
        this.alternate = _alternate;
    }

    // Getters for object's attributes.
    public KeyedText getGeneral() {
        return general;
    }

    public KeyedTextArrayList getAlternate() {
        return alternate;
    }

    // Setters for object's attributes.
    public void setGeneral(KeyedText general) {
        this.general = general;
    }

    public void setAlternate(KeyedTextArrayList alternate) {
        this.alternate = alternate;
    }

    @Override
    public String toString() {
        return "Symbols{" + "general=" + general + ", alternate=" + alternate + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(general);
            os.writeObject(alternate);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.general = (KeyedText) is.readObject();
            this.alternate = (KeyedTextArrayList) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
        }};
    }

}