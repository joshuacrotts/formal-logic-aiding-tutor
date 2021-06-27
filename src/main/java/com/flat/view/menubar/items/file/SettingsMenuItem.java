package com.flat.view.menubar.items.file;

import com.flat.models.fx.FxMenuBarData;
import com.flat.view.settings.SettingsStage;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsMenuItem extends MenuItem {

    public SettingsMenuItem() {
        super.textProperty().bind(FxMenuBarData.getSettings().textProperty());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            new SettingsStage();
        });
    }

}