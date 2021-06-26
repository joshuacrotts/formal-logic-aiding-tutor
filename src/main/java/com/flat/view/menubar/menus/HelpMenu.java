package com.flat.view.menubar.menus;

import com.flat.models.fx.FxMenuBarData;
import com.flat.view.menubar.items.help.AboutMenuItem;
import javafx.scene.control.Menu;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class HelpMenu extends Menu {
    private AboutMenuItem aboutMenuItem = new AboutMenuItem();

    public HelpMenu () {
        super.textProperty().bind(FxMenuBarData.getHelp().textProperty());
        super.getItems().addAll(this.aboutMenuItem);
    }

}