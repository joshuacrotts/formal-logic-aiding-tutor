package com.flat.models.data.menubar.menus.help;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.menubar.menus.help.items.AboutMenuItem;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class HelpMenu extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        HELP,
    }

    private KeyedText help = new KeyedText(HelpMenu.class, Keys.HELP, "Help");
    private AboutMenuItem aboutMenuItem = new AboutMenuItem();

    public HelpMenu () {
    }

    // Getters for object's attributes.
    public KeyedText getHelp() {
        return help;
    }

    public AboutMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    // Setters for object's attributes.
    public void setHelp(KeyedText help) {
        this.help = help;
    }

    public void setAboutMenuItem(AboutMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    @Override
    public String toString() {
        return "HelpMenu{" + "help=" + help + ", aboutMenuItem=" + aboutMenuItem + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.help);
            os.writeObject(this.aboutMenuItem);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.help = (KeyedText) is.readObject();
            this.aboutMenuItem = (AboutMenuItem) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(help);
            addAll(aboutMenuItem.toTranslate());
        }};
    }

}