package com.flat.view.menubar.menus.export;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.Menu;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportMenu extends Menu {
    private ExportAsLatexMenu exportAsLatexMenu = new ExportAsLatexMenu();
    private ExportAsPdfMenu exportAsPdfMenu = new ExportAsPdfMenu();

    public ExportMenu () {
        super.textProperty().bind(FxMenuBarData.getExport().textProperty());
        super.getItems().addAll(this.exportAsLatexMenu, this.exportAsPdfMenu);
    }

}