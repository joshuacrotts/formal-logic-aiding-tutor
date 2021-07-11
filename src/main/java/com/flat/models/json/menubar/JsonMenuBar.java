package com.flat.models.json.menubar;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.menus.JsonFileMenu;
import com.flat.models.json.menubar.menus.JsonHelpMenu;
import com.flat.models.json.menubar.menus.export.JsonExportMenu;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonMenuBar extends Translatable {
    private JsonFileMenu fileMenu = new JsonFileMenu();
    private JsonExportMenu exportMenu = new JsonExportMenu();
    private JsonHelpMenu helpMenu = new JsonHelpMenu();

    // Getters for object's attributes.
    public JsonFileMenu getFileMenu() {
        return fileMenu;
    }

    public JsonExportMenu getExportMenu() {
        return exportMenu;
    }

    public JsonHelpMenu getHelpMenu() {
        return helpMenu;
    }

    // Setters for object's attributes.
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
        return new LinkedList<JsonString>() {{
            addAll(fileMenu.toTranslate());
            addAll(exportMenu.toTranslate());
            addAll(helpMenu.toTranslate());
        }};
    }

}