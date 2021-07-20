package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.menubar.MenuBarData;
import com.flat.view.data.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTreeContextButton extends ContextButton {

    public PdfTruthTreeContextButton () {
        super(MenuBarData.getPdfLatexTruthTree().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}