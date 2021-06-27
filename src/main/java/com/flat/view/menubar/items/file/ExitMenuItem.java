package com.flat.view.menubar.items.file;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExitMenuItem extends MenuItem {

    public ExitMenuItem() {
        super.textProperty().bind(FxMenuBarData.getExit().textProperty());
        super.setOnAction((event) -> {
            System.exit(0);
        });
    }

}