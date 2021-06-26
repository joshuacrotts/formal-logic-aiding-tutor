package com.flat.models.json.menubar.menus;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.items.help.JsonAboutMenuItem;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonHelpMenu extends Translatable {
    @Expose
    private JsonString help = new JsonString("Help");
    @Expose
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
        return new LinkedList<JsonString>(){{
            add(help);
            addAll(aboutMenuItem.toTranslate());
        }};
    }

}