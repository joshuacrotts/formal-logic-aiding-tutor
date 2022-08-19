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
public class ExitMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        EXIT,
    }

    private KeyedText exit = new KeyedText(ExitMenuItem.class, Keys.EXIT, "Exit");

    // Getters for object's attributes.
    public KeyedText getExit() {
        return exit;
    }

    // Setters for object's attributes.
    public void setExit(KeyedText exit) {
        this.exit = exit;
    }

    @Override
    public String toString() {
        return "ExitMenuItem{" + "exit=" + exit + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.exit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.exit = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(exit);
        }};
    }

}