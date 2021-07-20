package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonExportMenu extends Translatable {

    public enum Key implements JsonKey {
        EXPORT,
    }

    private KeyedJsonString export = new KeyedJsonString(JsonExportMenu.class, Key.EXPORT, "Export");
    private JsonExportAsLatexMenu exportAsLatexMenu = new JsonExportAsLatexMenu();
    private JsonExportAsPdfMenu exportAsPdfMenu = new JsonExportAsPdfMenu();

    public KeyedJsonString getExport() {
        return export;
    }

    public void setExport(KeyedJsonString export) {
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
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(export);
            addAll(exportAsLatexMenu.toTranslate());
            addAll(exportAsPdfMenu.toTranslate());
        }};
    }

}