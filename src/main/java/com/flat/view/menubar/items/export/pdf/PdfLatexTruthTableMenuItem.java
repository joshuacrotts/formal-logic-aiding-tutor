package com.flat.view.menubar.items.export.pdf;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexTruthTableMenuItem extends MenuItem {

    public PdfLatexTruthTableMenuItem() {
        super.textProperty().bind(FxMenuBarData.getPdfLatexTruthTable().textProperty());
    }

}