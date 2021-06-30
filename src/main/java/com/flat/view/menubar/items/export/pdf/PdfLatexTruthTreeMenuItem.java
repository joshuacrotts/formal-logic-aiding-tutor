package com.flat.view.menubar.items.export.pdf;

import com.flat.view.viewdata.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexTruthTreeMenuItem extends MenuItem {

    public PdfLatexTruthTreeMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexTruthTree().textProperty());
    }

}