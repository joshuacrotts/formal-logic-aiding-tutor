package com.flat.view.menubar.menus;

import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.menubar.items.file.ExitMenuItem;
import com.flat.view.menubar.items.file.ResetViewMenuItem;
import com.flat.view.menubar.items.file.SettingsMenuItem;
import javafx.scene.control.Menu;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FileMenu extends Menu {
    private final ResetViewMenuItem restartMenuItem = new ResetViewMenuItem();
    private final SettingsMenuItem settingsMenuItem = new SettingsMenuItem();
    private final ExitMenuItem exitMenuItem = new ExitMenuItem();

    public FileMenu() {
        super.textProperty().bind(MenuBarData.getFile().textProperty());
        super.getItems().addAll(this.restartMenuItem,
                this.settingsMenuItem,
                this.exitMenuItem
        );
    }

}