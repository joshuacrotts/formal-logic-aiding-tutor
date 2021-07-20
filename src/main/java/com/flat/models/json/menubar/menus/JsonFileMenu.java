package com.flat.models.json.menubar.menus;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.menubar.items.file.JsonExitMenuItem;
import com.flat.models.json.menubar.items.file.JsonResetViewMenuItem;
import com.flat.models.json.menubar.items.file.JsonSettingsMenuItem;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonFileMenu extends Translatable {

    public enum Keys implements JsonKey {
        FILE,
    }

    private KeyedJsonString file = new KeyedJsonString(JsonFileMenu.class, Keys.FILE, "File");
    private JsonResetViewMenuItem resetViewMenuItem = new JsonResetViewMenuItem();
    private JsonSettingsMenuItem settingsMenuItem = new JsonSettingsMenuItem();
    private JsonExitMenuItem exitMenuItem = new JsonExitMenuItem();

    public KeyedJsonString getFile() {
        return file;
    }

    public void setFile(KeyedJsonString file) {
        this.file = file;
    }

    public JsonResetViewMenuItem getResetViewMenuItem() {
        return resetViewMenuItem;
    }

    public void setResetViewMenuItem(JsonResetViewMenuItem resetViewMenuItem) {
        this.resetViewMenuItem = resetViewMenuItem;
    }

    public JsonSettingsMenuItem getSettingsMenuItem() {
        return settingsMenuItem;
    }

    public void setSettingsMenuItem(JsonSettingsMenuItem settingsMenuItem) {
        this.settingsMenuItem = settingsMenuItem;
    }

    public JsonExitMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public void setExitMenuItem(JsonExitMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(file);
            addAll(resetViewMenuItem.toTranslate());
            addAll(settingsMenuItem.toTranslate());
            addAll(exitMenuItem.toTranslate());
        }};
    }

}