package com.flat.models.data.menubar.menus.file.items;

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
public class ResetViewMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        RESET,
    }

    private KeyedText reset = new KeyedText(ResetViewMenuItem.class, Keys.RESET, "Reset");

    public ResetViewMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getReset() {
        return reset;
    }

    // Setters for object's attributes.
    public void setReset(KeyedText reset) {
        this.reset = reset;
    }

    @Override
    public String toString() {
        return "ResetViewMenuItem{" + "reset=" + reset + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.reset);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.reset = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(reset);
        }};
    }

}