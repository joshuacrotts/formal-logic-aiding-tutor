package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTableMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTableContextButton extends ContextButton {

    public PdfTruthTableContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTableMenuItem.class, LatexTruthTableMenuItem.Keys.LATEX_TRUTH_TABLE));
    }

}