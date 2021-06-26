package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonExportMenu extends Translatable {
    @Expose
    private JsonString export = new JsonString("Export");
    @Expose
    private JsonExportAsLatexMenu exportAsLatexMenu = new JsonExportAsLatexMenu();
    @Expose
    private JsonExportAsPdfMenu exportAsPdfMenu = new JsonExportAsPdfMenu();

    public JsonString getExport() {
        return export;
    }

    public JsonExportAsLatexMenu getExportAsLatexMenu() {
        return exportAsLatexMenu;
    }

    public JsonExportAsPdfMenu getExportAsPdfMenu() {
        return exportAsPdfMenu;
    }

    public void setExport(JsonString export) {
        this.export = export;
    }

    public void setExportAsLatexMenu(JsonExportAsLatexMenu exportAsLatexMenu) {
        this.exportAsLatexMenu = exportAsLatexMenu;
    }

    public void setExportAsPdfMenu(JsonExportAsPdfMenu exportAsPdfMenu) {
        this.exportAsPdfMenu = exportAsPdfMenu;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(export);
            addAll(exportAsLatexMenu.toTranslate());
            addAll(exportAsPdfMenu.toTranslate());
        }};
    }

}