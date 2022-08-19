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
public class LatexTruthTreeMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LATEX_TRUTH_TREE,
    }

    private KeyedText latexTruthTree = new KeyedText(LatexTruthTreeMenuItem.class, Keys.LATEX_TRUTH_TREE, "LaTeX Truth Tree");

    public LatexTruthTreeMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getLatexTruthTree() {
        return latexTruthTree;
    }

    // Setters for object's attributes.
    public void setLatexTruthTree(KeyedText latexTruthTree) {
        this.latexTruthTree = latexTruthTree;
    }

    @Override
    public String toString() {
        return "LatexTruthTreeMenuItem{" + "latexTruthTree=" + latexTruthTree + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.latexTruthTree);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.latexTruthTree = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(latexTruthTree);
        }};
    }

}