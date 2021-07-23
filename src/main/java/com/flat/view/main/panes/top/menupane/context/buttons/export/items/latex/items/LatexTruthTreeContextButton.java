package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTreeContextButton extends ContextButton {

    public LatexTruthTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTreeMenuItem.class, LatexTruthTreeMenuItem.Keys.LATEX_TRUTH_TREE));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}