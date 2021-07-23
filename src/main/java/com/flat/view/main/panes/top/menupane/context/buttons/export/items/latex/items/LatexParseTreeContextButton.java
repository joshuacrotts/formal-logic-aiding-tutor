package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexParseTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexParseTreeContextButton extends ContextButton {

    public LatexParseTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexParseTreeMenuItem.class, LatexParseTreeMenuItem.Keys.LATEX_PARSE_TREE));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}