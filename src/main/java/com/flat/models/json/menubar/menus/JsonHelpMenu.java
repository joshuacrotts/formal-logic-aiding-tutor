package com.flat.models.json.menubar.menus;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.items.help.JsonAboutMenuItem;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonHelpMenu extends Translatable {
    private JsonString help = new JsonString("Help");
    private JsonAboutMenuItem aboutMenuItem = new JsonAboutMenuItem();

    public JsonString getHelp() {
        return help;
    }

    public void setHelp(JsonString help) {
        this.help = help;
    }

    public JsonAboutMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public void setAboutMenuItem(JsonAboutMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(help);
            addAll(aboutMenuItem.toTranslate());
        }};
    }

}