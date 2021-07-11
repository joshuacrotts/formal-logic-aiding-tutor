package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonExportMenu extends Translatable {
    private JsonString export = new JsonString("Export");
    private JsonExportAsLatexMenu exportAsLatexMenu = new JsonExportAsLatexMenu();
    private JsonExportAsPdfMenu exportAsPdfMenu = new JsonExportAsPdfMenu();

    public JsonString getExport() {
        return export;
    }

    public void setExport(JsonString export) {
        this.export = export;
    }

    public JsonExportAsLatexMenu getExportAsLatexMenu() {
        return exportAsLatexMenu;
    }

    public void setExportAsLatexMenu(JsonExportAsLatexMenu exportAsLatexMenu) {
        this.exportAsLatexMenu = exportAsLatexMenu;
    }

    public JsonExportAsPdfMenu getExportAsPdfMenu() {
        return exportAsPdfMenu;
    }

    public void setExportAsPdfMenu(JsonExportAsPdfMenu exportAsPdfMenu) {
        this.exportAsPdfMenu = exportAsPdfMenu;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(export);
            addAll(exportAsLatexMenu.toTranslate());
            addAll(exportAsPdfMenu.toTranslate());
        }};
    }

}