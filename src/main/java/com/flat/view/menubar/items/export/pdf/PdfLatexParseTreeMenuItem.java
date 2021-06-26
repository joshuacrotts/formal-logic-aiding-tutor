package com.flat.view.menubar.items.export.pdf;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfLatexParseTreeMenuItem extends MenuItem {

    public PdfLatexParseTreeMenuItem () {
        super.textProperty().bind(FxMenuBarData.getPdfLatexParseTree().textProperty());
    }

}