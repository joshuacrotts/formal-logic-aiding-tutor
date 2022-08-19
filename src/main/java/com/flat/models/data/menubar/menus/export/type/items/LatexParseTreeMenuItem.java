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
public class LatexParseTreeMenuItem extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LATEX_PARSE_TREE,
    }

    private KeyedText latexParseTree = new KeyedText(LatexParseTreeMenuItem.class, Keys.LATEX_PARSE_TREE, "LaTeX Parse Tree");

    public LatexParseTreeMenuItem () {
    }

    // Getters for object's attributes.
    public KeyedText getLatexParseTree() {
        return latexParseTree;
    }

    // Setters for object's attributes.
    public void setLatexParseTree(KeyedText latexParseTree) {
        this.latexParseTree = latexParseTree;
    }

    @Override
    public String toString() {
        return "LatexParseTreeMenuItem{" + "latexParseTree=" + latexParseTree + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.latexParseTree);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.latexParseTree = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(latexParseTree);
        }};
    }

}