package com.flat.view.main.menupane.context.buttons.export.items.pdf;

import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.main.menupane.context.buttons.export.items.pdf.items.PdfParseTreeContextButton;
import com.flat.view.main.menupane.context.buttons.export.items.pdf.items.PdfTruthTableContextButton;
import com.flat.view.main.menupane.context.buttons.export.items.pdf.items.PdfTruthTreeContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PdfContextButton extends ContextButton {

    public PdfContextButton () {
        super(MenuBarData.getExportAsPdf().textProperty(),
                new PdfParseTreeContextButton(),
                new PdfTruthTreeContextButton(),
                new PdfTruthTableContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.setOffsetY(-ContextButton.MENU_HEIGHT / 2);
        super.setOffsetX(ContextButton.MENU_WIDTH);
    }

}