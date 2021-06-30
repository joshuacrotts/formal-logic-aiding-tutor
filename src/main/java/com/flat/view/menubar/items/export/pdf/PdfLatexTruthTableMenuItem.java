package com.flat.view.menubar.items.export.pdf;

import com.flat.view.viewdata.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexTruthTableMenuItem extends MenuItem {

    public PdfLatexTruthTableMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexTruthTable().textProperty());
    }

}