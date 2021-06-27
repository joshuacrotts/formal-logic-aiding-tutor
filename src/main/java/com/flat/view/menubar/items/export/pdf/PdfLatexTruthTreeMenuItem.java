package com.flat.view.menubar.items.export.pdf;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexTruthTreeMenuItem extends MenuItem {

    public PdfLatexTruthTreeMenuItem() {
        super.textProperty().bind(FxMenuBarData.getPdfLatexTruthTree().textProperty());
    }

}