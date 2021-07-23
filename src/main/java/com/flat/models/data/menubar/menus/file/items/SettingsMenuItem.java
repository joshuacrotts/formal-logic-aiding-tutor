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
public class SettingsMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        SETTINGS,
    }

    private KeyedText settings = new KeyedText(SettingsMenuItem.class, Keys.SETTINGS, "Settings");

    public SettingsMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getSettings() {
        return settings;
    }

    // Setters for object's attributes.
    public void setSettings(KeyedText settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "SettingsMenuItem{" + "settings=" + settings + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.settings);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.settings = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(settings);
        }};
    }

}