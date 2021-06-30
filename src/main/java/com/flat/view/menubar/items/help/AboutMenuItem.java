package com.flat.view.menubar.items.help;

import com.flat.view.viewdata.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AboutMenuItem extends MenuItem {

    public AboutMenuItem() {
        super.textProperty().bind(MenuBarData.getAbout().textProperty());
    }

}