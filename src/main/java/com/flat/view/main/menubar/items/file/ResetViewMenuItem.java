package com.flat.view.main.menubar.items.file;

import com.flat.controller.Controller;
import com.flat.view.viewdata.menubar.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ResetViewMenuItem extends MenuItem {

    public ResetViewMenuItem() {
        super.textProperty().bind(MenuBarData.getResetView().textProperty());
        super.setOnAction((event) -> {
            Controller.resetView();
        });
    }

}