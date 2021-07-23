package com.flat.models.data.settings.tabs.advance;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.settings.tabs.advance.content.AdvancePane;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class AdvanceTabData extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        ADVANCE,
    }

    private KeyedText advance = new KeyedText(AdvanceTabData.class, Keys.ADVANCE, "Advance");
    private AdvancePane advancePane = new AdvancePane();

    public AdvanceTabData () {
    }

    // Getters for object's attributes.
    public KeyedText getAdvance() {
        return advance;
    }

    public AdvancePane getAdvancePane() {
        return advancePane;
    }

    // Setters for object's attributes.
    public void setAdvance(KeyedText advance) {
        this.advance = advance;
    }

    public void setAdvancePane(AdvancePane advancePane) {
        this.advancePane = advancePane;
    }

    @Override
    public String toString() {
        return "AdvanceTab{" + "advance=" + advance + ", advancePane=" + advancePane + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.advance);
            os.writeObject(this.advancePane);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.advance = (KeyedText) is.readObject();
            this.advancePane = (AdvancePane) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(advance);
            addAll(advancePane.toTranslate());
        }};
    }

}