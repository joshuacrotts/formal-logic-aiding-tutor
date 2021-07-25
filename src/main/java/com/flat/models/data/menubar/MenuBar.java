package com.flat.models.data.menubar;

import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.menubar.menus.export.ExportMenu;
import com.flat.models.data.menubar.menus.file.FileMenu;
import com.flat.models.data.menubar.menus.help.HelpMenu;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class MenuBar extends Translatable implements Serializable {

    private FileMenu fileMenu = new FileMenu();
    private ExportMenu exportMenu = new ExportMenu();
    private HelpMenu helpMenu = new HelpMenu();

    public MenuBar () {
    }

    // Getters for object's attributes.
    public FileMenu getFileMenu() {
        return fileMenu;
    }

    public ExportMenu getExportMenu() {
        return exportMenu;
    }

    public HelpMenu getHelpMenu() {
        return helpMenu;
    }

    // Setters for object's attributes.
    public void setFileMenu(FileMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public void setExportMenu(ExportMenu exportMenu) {
        this.exportMenu = exportMenu;
    }

    public void setHelpMenu(HelpMenu helpMenu) {
        this.helpMenu = helpMenu;
    }

    @Override
    public String toString() {
        return "MenuBar{" + "fileMenu=" + fileMenu + ", exportMenu=" + exportMenu + ", helpMenu=" + helpMenu + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.fileMenu);
            os.writeObject(this.exportMenu);
            os.writeObject(this.helpMenu);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.fileMenu = (FileMenu) is.readObject();
            this.exportMenu = (ExportMenu) is.readObject();
            this.helpMenu = (HelpMenu) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(fileMenu.toTranslate());
            addAll(exportMenu.toTranslate());
            addAll(helpMenu.toTranslate());
        }};
    }

}