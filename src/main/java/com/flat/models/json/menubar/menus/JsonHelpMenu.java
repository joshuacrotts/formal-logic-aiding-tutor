package com.flat.models.json.menubar.menus;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.menubar.items.help.JsonAboutMenuItem;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonHelpMenu extends Translatable {

    public enum Keys implements JsonKey {
        HELP,
    }

    private KeyedJsonString help = new KeyedJsonString(JsonHelpMenu.class, Keys.HELP, "Help");
    private JsonAboutMenuItem aboutMenuItem = new JsonAboutMenuItem();

    public KeyedJsonString getHelp() {
        return help;
    }

    public void setHelp(KeyedJsonString help) {
        this.help = help;
    }

    public JsonAboutMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public void setAboutMenuItem(JsonAboutMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(help);
            addAll(aboutMenuItem.toTranslate());
        }};
    }

}