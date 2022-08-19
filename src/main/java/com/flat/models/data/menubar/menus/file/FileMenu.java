package com.flat.models.data.menubar.menus.file;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.menubar.menus.file.items.ExitMenuItem;
import com.flat.models.data.menubar.menus.file.items.ResetViewMenuItem;
import com.flat.models.data.menubar.menus.file.items.SettingsMenuItem;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class FileMenu extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        FILE,
    }

    private KeyedText file = new KeyedText(FileMenu.class, Keys.FILE, "File");
    private ResetViewMenuItem resetViewMenuItem = new ResetViewMenuItem();
    private SettingsMenuItem settingsMenuItem = new SettingsMenuItem();
    private ExitMenuItem exitMenuItem = new ExitMenuItem();

    public FileMenu () {
    }

    // Getters for object's attributes.
    public KeyedText getFile() {
        return file;
    }

    public ResetViewMenuItem getResetViewMenuItem() {
        return resetViewMenuItem;
    }

    public SettingsMenuItem getSettingsMenuItem() {
        return settingsMenuItem;
    }

    public ExitMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    // Setters for object's attributes.
    public void setFile(KeyedText file) {
        this.file = file;
    }

    public void setResetViewMenuItem(ResetViewMenuItem resetViewMenuItem) {
        this.resetViewMenuItem = resetViewMenuItem;
    }

    public void setSettingsMenuItem(SettingsMenuItem settingsMenuItem) {
        this.settingsMenuItem = settingsMenuItem;
    }

    public void setExitMenuItem(ExitMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    @Override
    public String toString() {
        return "FileMenu{" + "file=" + file + ", resetViewMenuItem=" + resetViewMenuItem + ", settingsMenuItem=" + settingsMenuItem + ", exitMenuItem=" + exitMenuItem + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.file);
            os.writeObject(this.resetViewMenuItem);
            os.writeObject(this.settingsMenuItem);
            os.writeObject(this.exitMenuItem);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.file = (KeyedText) is.readObject();
            this.resetViewMenuItem = (ResetViewMenuItem) is.readObject();
            this.settingsMenuItem = (SettingsMenuItem) is.readObject();
            this.exitMenuItem = (ExitMenuItem) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(file);
            addAll(resetViewMenuItem.toTranslate());
            addAll(settingsMenuItem.toTranslate());
            addAll(exitMenuItem.toTranslate());
        }};
    }

}