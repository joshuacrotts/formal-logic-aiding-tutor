package com.flat.models.data.settings.tabs.advanced;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.settings.tabs.advanced.content.AdvancedPane;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class AdvancedTabData extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        ADVANCE,
    }

    private KeyedText advanced = new KeyedText(AdvancedTabData.class, Keys.ADVANCE, "Advanced");
    private AdvancedPane advancedPane = new AdvancedPane();

    public AdvancedTabData () {
    }

    // Getters for object's attributes.
    public KeyedText getAdvanced() {
        return advanced;
    }

    public AdvancedPane getAdvancedPane() {
        return advancedPane;
    }

    // Setters for object's attributes.
    public void setAdvanced(KeyedText advanced) {
        this.advanced = advanced;
    }

    public void setAdvancedPane(AdvancedPane advancedPane) {
        this.advancedPane = advancedPane;
    }

    @Override
    public String toString() {
        return "AdvancedTab{" + "advanced=" + advanced + ", advancedPane=" + advancedPane + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.advanced);
            os.writeObject(this.advancedPane);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.advanced = (KeyedText) is.readObject();
            this.advancedPane = (AdvancedPane) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(advanced);
            addAll(advancedPane.toTranslate());
        }};
    }

}