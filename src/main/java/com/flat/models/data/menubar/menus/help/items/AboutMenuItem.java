package com.flat.models.data.menubar.menus.help.items;

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
public class AboutMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        ABOUT,
    }

    private KeyedText about = new KeyedText(AboutMenuItem.class, Keys.ABOUT, "About");

    public AboutMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getAbout() {
        return about;
    }

    // Setters for object's attributes.
    public void setAbout(KeyedText about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "AboutMenuItem{" + "about=" + about + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.about);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.about = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(about);
        }};
    }

}