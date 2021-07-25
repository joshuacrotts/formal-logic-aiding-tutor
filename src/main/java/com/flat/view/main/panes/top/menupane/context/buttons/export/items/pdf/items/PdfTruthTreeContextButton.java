package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTreeContextButton extends ContextButton {

    public PdfTruthTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTreeMenuItem.class, LatexTruthTreeMenuItem.Keys.LATEX_TRUTH_TREE));
    }

}