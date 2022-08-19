package com.flat.models.data.settings.tabs.appearance;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.settings.tabs.appearance.content.ColorPane;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class AppearanceTabData extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        APPEARANCE,
    }

    private KeyedText appearance = new KeyedText(AppearanceTabData.class, Keys.APPEARANCE, "Appearance");
    private ColorPane colorPane = new ColorPane();

    public AppearanceTabData () {
    }

    // Getters for object's attributes.
    public KeyedText getAppearance() {
        return appearance;
    }

    public ColorPane getColorPane() {
        return colorPane;
    }

    // Setters for object's attributes.
    public void setAppearance(KeyedText appearance) {
        this.appearance = appearance;
    }

    public void setColorPane(ColorPane colorPane) {
        this.colorPane = colorPane;
    }

    @Override
    public String toString() {
        return "AppearanceTab{" + "appearance=" + appearance + ", colorPane=" + colorPane + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.appearance);
            os.writeObject(this.colorPane);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.appearance = (KeyedText) is.readObject();
            this.colorPane = (ColorPane) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(appearance);
            addAll(colorPane.toTranslate());
        }};
    }

}