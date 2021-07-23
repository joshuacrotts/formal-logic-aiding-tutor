package com.flat.models.data.settings.tabs.appearance.content;

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
public class ColorPane extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        PRIMARY_COLOR,
        SECONDARY_COLOR,
        BORDER_COLOR
    }

    private KeyedText primaryColor = new KeyedText(ColorPane.class, Keys.PRIMARY_COLOR, "Primary Color:");
    private KeyedText secondaryColor = new KeyedText(ColorPane.class, Keys.SECONDARY_COLOR, "Secondary Color:");
    private KeyedText borderColor = new KeyedText(ColorPane.class, Keys.BORDER_COLOR, "Border Color:");

    public ColorPane () {
    }

    // Getters for object's attributes.
    public KeyedText getPrimaryColor() {
        return primaryColor;
    }

    public KeyedText getSecondaryColor() {
        return secondaryColor;
    }

    public KeyedText getBorderColor() {
        return borderColor;
    }

    // Setters for object's attributes.
    public void setPrimaryColor(KeyedText primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(KeyedText secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public void setBorderColor(KeyedText borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String toString() {
        return "ColorPane{" + "primaryColor=" + primaryColor + ", secondaryColor=" + secondaryColor + ", borderColor=" + borderColor + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.primaryColor);
            os.writeObject(this.secondaryColor);
            os.writeObject(this.borderColor);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.primaryColor = (KeyedText) is.readObject();
            this.secondaryColor = (KeyedText) is.readObject();
            this.borderColor = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(primaryColor);
            add(secondaryColor);
            add(borderColor);
        }};
    }

}