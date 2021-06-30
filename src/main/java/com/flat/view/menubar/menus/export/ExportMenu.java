package com.flat.view.menubar.menus.export;

import com.flat.view.viewdata.MenuBarData;
import javafx.scene.control.Menu;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportMenu extends Menu {
    private final ExportAsLatexMenu exportAsLatexMenu = new ExportAsLatexMenu();
    private final ExportAsPdfMenu exportAsPdfMenu = new ExportAsPdfMenu();

    public ExportMenu() {
        super.textProperty().bind(MenuBarData.getExport().textProperty());
        super.getItems().addAll(this.exportAsLatexMenu, this.exportAsPdfMenu);
    }

}