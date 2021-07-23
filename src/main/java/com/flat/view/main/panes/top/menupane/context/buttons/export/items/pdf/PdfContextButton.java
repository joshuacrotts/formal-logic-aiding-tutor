package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.pdf.ExportAsPdfMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.PdfParseTreeContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.PdfTruthTableContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.PdfTruthTreeContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfContextButton extends ContextButton {

    public PdfContextButton () {
        super(Controller.MAPPED_TEXT.getValue(ExportAsPdfMenu.class, ExportAsPdfMenu.Keys.EXPORT_AS_PDF),
                new PdfParseTreeContextButton(),
                new PdfTruthTreeContextButton(),
                new PdfTruthTableContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.setOffsetY(-ContextButton.MENU_HEIGHT / 2);
        super.setOffsetX(ContextButton.MENU_WIDTH);
    }

}