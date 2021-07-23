package com.flat.models.data.menubar.menus.export;

import com.flat.models.data.menubar.menus.export.type.pdf.ExportAsPdfMenu;
import com.flat.models.data.menubar.menus.export.type.latex.ExportAsLatexMenu;
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
public class ExportMenu extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        EXPORT,
    }

    private KeyedText export = new KeyedText(ExportMenu.class, Keys.EXPORT, "Export");
    private ExportAsLatexMenu exportAsLatexMenu = new ExportAsLatexMenu();
    private ExportAsPdfMenu exportAsPdfMenu = new ExportAsPdfMenu();

    public ExportMenu () {
    }

    // Getters for object's attributes.
    public KeyedText getExport() {
        return export;
    }

    public ExportAsLatexMenu getExportAsLatexMenu() {
        return exportAsLatexMenu;
    }

    public ExportAsPdfMenu getExportAsPdfMenu() {
        return exportAsPdfMenu;
    }

    // Setters for object's attributes.
    public void setExport(KeyedText export) {
        this.export = export;
    }

    public void setExportAsLatexMenu(ExportAsLatexMenu exportAsLatexMenu) {
        this.exportAsLatexMenu = exportAsLatexMenu;
    }

    public void setExportAsPdfMenu(ExportAsPdfMenu exportAsPdfMenu) {
        this.exportAsPdfMenu = exportAsPdfMenu;
    }

    @Override
    public String toString() {
        return "ExportMenu{" + "export=" + export + ", exportAsLatexMenu=" + exportAsLatexMenu + ", exportAsPdfMenu=" + exportAsPdfMenu + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.export);
            os.writeObject(this.exportAsLatexMenu);
            os.writeObject(this.exportAsPdfMenu);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.export = (KeyedText) is.readObject();
            this.exportAsLatexMenu = (ExportAsLatexMenu) is.readObject();
            this.exportAsPdfMenu = (ExportAsPdfMenu) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(export);
            addAll(exportAsLatexMenu.toTranslate());
            addAll(exportAsPdfMenu.toTranslate());
        }};
    }

}