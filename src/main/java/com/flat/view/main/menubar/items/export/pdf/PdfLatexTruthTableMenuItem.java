package com.flat.view.main.menubar.items.export.pdf;

import com.flat.view.viewdata.menubar.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexTruthTableMenuItem extends MenuItem {

    public PdfLatexTruthTableMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexTruthTable().textProperty());
    }

}