package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexParseTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfParseTreeContextButton extends ContextButton {

    public PdfParseTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexParseTreeMenuItem.class, LatexParseTreeMenuItem.Keys.LATEX_PARSE_TREE));
    }

}