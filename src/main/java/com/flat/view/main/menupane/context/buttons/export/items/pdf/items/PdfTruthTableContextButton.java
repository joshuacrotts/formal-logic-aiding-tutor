package com.flat.view.main.menupane.context.buttons.export.items.pdf.items;

import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfTruthTableContextButton extends ContextButton {

    public PdfTruthTableContextButton () {
        super(MenuBarData.getPdfLatexTruthTable().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}