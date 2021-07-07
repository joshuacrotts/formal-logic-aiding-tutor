package com.flat.view.menubar.items.file;

import com.flat.controller.Controller;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.settings.SettingsStage;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsMenuItem extends MenuItem {

    public SettingsMenuItem() {
        super.textProperty().bind(MenuBarData.getSettings().textProperty());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction((event) -> {
            Controller.applyFont(new SettingsStage());
        });
    }

}