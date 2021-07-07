package com.flat.view.main.menubar.items.export.pdf;

import com.flat.view.viewdata.menubar.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexParseTreeMenuItem extends MenuItem {

    public PdfLatexParseTreeMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexParseTree().textProperty());
    }

}