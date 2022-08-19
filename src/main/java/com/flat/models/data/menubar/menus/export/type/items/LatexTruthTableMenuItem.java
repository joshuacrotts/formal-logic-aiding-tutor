package com.flat.models.data.menubar.menus.export.type.items;

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
public class LatexTruthTableMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LATEX_TRUTH_TABLE,
    }

    private KeyedText latexTruthTable = new KeyedText(LatexTruthTableMenuItem.class, Keys.LATEX_TRUTH_TABLE, "LaTeX truth table");

    public LatexTruthTableMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getLatexTruthTable() {
        return latexTruthTable;
    }

    // Setters for object's attributes.
    public void setLatexTruthTable(KeyedText latexTruthTable) {
        this.latexTruthTable = latexTruthTable;
    }

    @Override
    public String toString() {
        return "LatexTruthTableMenuItem{" + "latexTruthTable=" + latexTruthTable + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.latexTruthTable);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.latexTruthTable = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(latexTruthTable);
        }};
    }

}