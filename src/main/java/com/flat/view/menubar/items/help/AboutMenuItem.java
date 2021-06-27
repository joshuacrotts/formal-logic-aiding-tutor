package com.flat.view.menubar.items.help;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AboutMenuItem extends MenuItem {

    public AboutMenuItem() {
        super.textProperty().bind(FxMenuBarData.getAbout().textProperty());
    }

}