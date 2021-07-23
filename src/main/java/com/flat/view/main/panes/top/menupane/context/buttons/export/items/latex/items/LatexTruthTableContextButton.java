package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTableMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTableContextButton extends ContextButton {

    public LatexTruthTableContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTableMenuItem.class, LatexTruthTableMenuItem.Keys.LATEX_TRUTH_TABLE));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}