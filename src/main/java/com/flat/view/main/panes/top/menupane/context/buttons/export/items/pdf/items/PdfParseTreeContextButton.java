package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfParseTreeContextButton extends ContextButton {

    public PdfParseTreeContextButton () {
        super(MenuBarData.getPdfLatexParseTree().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}