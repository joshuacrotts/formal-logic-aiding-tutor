package com.flat.view.menubar.items.file;

import com.flat.controller.Controller;
import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ResetViewMenuItem extends MenuItem {

    public ResetViewMenuItem() {
        super.textProperty().bind(FxMenuBarData.getResetView().textProperty());
        super.setOnAction((event) -> {Controller.resetView();});
    }

}