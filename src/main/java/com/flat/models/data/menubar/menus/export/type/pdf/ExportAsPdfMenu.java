package com.flat.models.data.menubar.menus.export.type.pdf;

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
public class ExportAsPdfMenu extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        EXPORT_AS_PDF,
    }

    private KeyedText exportAsPdf = new KeyedText(ExportAsPdfMenu.class, Keys.EXPORT_AS_PDF, "Export as Pdf (.pdf)");
    private LatexParseTreeMenuItem latexParseTreeMenuItem = new LatexParseTreeMenuItem();
    private LatexTruthTreeMenuItem latexTruthTreeMenuItem = new LatexTruthTreeMenuItem();
    private LatexTruthTableMenuItem latexTruthTableMenuItem = new LatexTruthTableMenuItem();

    public ExportAsPdfMenu () {
    }

    //Getters for object's attributes.
    public KeyedText getExportAsPdf() {
        return exportAsPdf;
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
    public void setExportAsPdf(KeyedText exportAsPdf) {
        this.exportAsPdf = exportAsPdf;
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
        return "ExportAsPdfMenu{" + "exportAsPdf=" + exportAsPdf + ", latexParseTreeMenuItem=" + latexParseTreeMenuItem + ", latexTruthTreeMenuItem=" + latexTruthTreeMenuItem + ", latexTruthTableMenuItem=" + latexTruthTableMenuItem + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.exportAsPdf);
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
            this.exportAsPdf = (KeyedText) is.readObject();
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
            add(exportAsPdf);
            addAll(latexParseTreeMenuItem.toTranslate());
            addAll(latexTruthTreeMenuItem.toTranslate());
            addAll(latexTruthTableMenuItem.toTranslate());
        }};
    }

}