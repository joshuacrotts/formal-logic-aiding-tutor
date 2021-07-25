package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.latex.ExportAsLatexMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexParseTreeContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexTruthTableContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexTruthTreeContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexContextButton extends ContextButton {

    public LatexContextButton () {
        super(Controller.MAPPED_TEXT.getValue(ExportAsLatexMenu.class, ExportAsLatexMenu.Keys.EXPORT_AS_LATEX),
                new LatexParseTreeContextButton(),
                new LatexTruthTreeContextButton(),
                new LatexTruthTableContextButton());
        super.setOffsetY(-ContextButton.MENU_HEIGHT / 2);
        super.setOffsetX(ContextButton.MENU_WIDTH);
    }

}