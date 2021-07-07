package com.flat.view.menubar.menus;

import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.menubar.items.help.AboutMenuItem;
import javafx.scene.control.Menu;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class HelpMenu extends Menu {
    private final AboutMenuItem aboutMenuItem = new AboutMenuItem();

    public HelpMenu() {
        super.textProperty().bind(MenuBarData.getHelp().textProperty());
        super.getItems().addAll(this.aboutMenuItem);
    }

}