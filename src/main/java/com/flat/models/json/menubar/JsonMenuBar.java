package com.flat.models.json.menubar;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.menus.JsonFileMenu;
import com.flat.models.json.menubar.menus.JsonHelpMenu;
import com.flat.models.json.menubar.menus.export.JsonExportMenu;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonMenuBar extends Translatable {
    @Expose
    private JsonFileMenu fileMenu = new JsonFileMenu();
    @Expose
    private JsonExportMenu exportMenu = new JsonExportMenu();
    @Expose
    private JsonHelpMenu helpMenu = new JsonHelpMenu();

    public JsonFileMenu getFileMenu() {
        return fileMenu;
    }

    public JsonExportMenu getExportMenu() {
        return exportMenu;
    }

    public JsonHelpMenu getHelpMenu() {
        return helpMenu;
    }

    public void setFileMenu(JsonFileMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public void setExportMenu(JsonExportMenu exportMenu) {
        this.exportMenu = exportMenu;
    }

    public void setHelpMenu(JsonHelpMenu helpMenu) {
        this.helpMenu = helpMenu;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            addAll(fileMenu.toTranslate());
            addAll(exportMenu.toTranslate());
            addAll(helpMenu.toTranslate());
        }};
    }

}