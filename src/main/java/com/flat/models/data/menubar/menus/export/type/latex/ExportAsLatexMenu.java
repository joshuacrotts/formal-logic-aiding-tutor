package com.flat.models.data.menubar.menus.export.type.latex;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.menubar.menus.export.type.items.LatexParseTreeMenuItem;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTableMenuItem;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTreeMenuItem;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class ExportAsLatexMenu extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        EXPORT_AS_LATEX,
    }

    private KeyedText exportAsLatex = new KeyedText(ExportAsLatexMenu.class, Keys.EXPORT_AS_LATEX, "Export as LaTeX (.tex)");
    private LatexParseTreeMenuItem latexParseTreeMenuItem = new LatexParseTreeMenuItem();
    private LatexTruthTreeMenuItem latexTruthTreeMenuItem = new LatexTruthTreeMenuItem();
    private LatexTruthTableMenuItem latexTruthTableMenuItem = new LatexTruthTableMenuItem();

    public ExportAsLatexMenu () {
    }

    // Getters for object's attributes.
    public KeyedText getExportAsLatex() {
        return exportAsLatex;
    }

    public LatexParseTreeMenuItem getLatexParseTreeMenuItem() {
        return latexParseTreeMenuItem;
    }

    public LatexTruthTreeMenuItem getLatexTruthTreeMenuItem() {
        return latexTruthTreeMenuItem;
    }

    public LatexTruthTableMenuItem getLatexTruthTableMenuItem() {
        return latexTruthTableMenuItem;
    }

    // Setters for object's attributes.
    public void setExportAsLatex(KeyedText exportAsLatex) {
        this.exportAsLatex = exportAsLatex;
    }

    public void setLatexParseTreeMenuItem(LatexParseTreeMenuItem latexParseTreeMenuItem) {
        this.latexParseTreeMenuItem = latexParseTreeMenuItem;
    }

    public void setLatexTruthTreeMenuItem(LatexTruthTreeMenuItem latexTruthTreeMenuItem) {
        this.latexTruthTreeMenuItem = latexTruthTreeMenuItem;
    }

    public void setLatexTruthTableMenuItem(LatexTruthTableMenuItem latexTruthTableMenuItem) {
        this.latexTruthTableMenuItem = latexTruthTableMenuItem;
    }

    @Override
    public String toString() {
        return "ExportAsLatexMenu{" + "exportAsLatex=" + exportAsLatex + ", latexParseTreeMenuItem=" + latexParseTreeMenuItem + ", latexTruthTreeMenuItem=" + latexTruthTreeMenuItem + ", latexTruthTableMenuItem=" + latexTruthTableMenuItem + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.exportAsLatex);
            os.writeObject(this.latexParseTreeMenuItem);
            os.writeObject(this.latexTruthTreeMenuItem);
            os.writeObject(latexTruthTableMenuItem);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.exportAsLatex = (KeyedText) is.readObject();
            this.latexParseTreeMenuItem = (LatexParseTreeMenuItem) is.readObject();
            this.latexTruthTreeMenuItem = (LatexTruthTreeMenuItem) is.readObject();
            this.latexTruthTableMenuItem = (LatexTruthTableMenuItem) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(exportAsLatex);
            addAll(latexParseTreeMenuItem.toTranslate());
            addAll(latexTruthTreeMenuItem.toTranslate());
            addAll(latexTruthTableMenuItem.toTranslate());
        }};
    }

}