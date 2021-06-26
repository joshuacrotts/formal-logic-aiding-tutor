package com.flat.view.menubar.items.file;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsMenuItem extends MenuItem {

    public SettingsMenuItem () {
        super.textProperty().bind(FxMenuBarData.getSettings().textProperty());
    }

}
