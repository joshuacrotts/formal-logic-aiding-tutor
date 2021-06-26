package com.flat.view.menubar.menus;

import com.flat.models.fx.FxMenuBarData;
import com.flat.view.menubar.items.file.ExitMenuItem;
import com.flat.view.menubar.items.file.ResetViewMenuItem;
import com.flat.view.menubar.items.file.SettingsMenuItem;
import javafx.scene.control.Menu;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FileMenu extends Menu {
    private ResetViewMenuItem restartMenuItem = new ResetViewMenuItem();
    private SettingsMenuItem settingsMenuItem = new SettingsMenuItem();
    private ExitMenuItem exitMenuItem = new ExitMenuItem();

    public FileMenu () {
        super.textProperty().bind(FxMenuBarData.getFile().textProperty());
        super.getItems().addAll(this.restartMenuItem,
                                this.settingsMenuItem,
                                this.exitMenuItem
        );
    }

}