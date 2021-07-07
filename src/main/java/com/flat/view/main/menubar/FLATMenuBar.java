package com.flat.view.main.menubar;

import com.flat.view.main.menubar.menus.FileMenu;
import com.flat.view.main.menubar.menus.HelpMenu;
import com.flat.view.main.menubar.menus.export.ExportMenu;
import javafx.scene.control.MenuBar;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FLATMenuBar extends MenuBar {
    private final FileMenu fileMenu = new FileMenu();
    private final ExportMenu exportMenu = new ExportMenu();
    private final HelpMenu aboutMenu = new HelpMenu();

    public FLATMenuBar() {
        super.getMenus().addAll(this.fileMenu, this.exportMenu, this.aboutMenu);
    }

}