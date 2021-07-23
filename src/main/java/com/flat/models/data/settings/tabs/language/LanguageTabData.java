package com.flat.models.data.settings.tabs.language;

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
public class LanguageTabData extends Translatable implements Serializable{

    public enum Keys implements KeyBase {
        LANGUAGE,
    }

    private KeyedText language = new KeyedText(LanguageTabData.class, Keys.LANGUAGE, "Language");

    public LanguageTabData () {
    }

    // Getters for object's attributes.
    public KeyedText getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setLanguage(KeyedText language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "LanguageTab{" + "language=" + language + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.language);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.language = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(language);
        }};
    }

}