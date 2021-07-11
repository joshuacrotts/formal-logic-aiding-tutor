package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTreeContextButton extends ContextButton {

    public LatexTruthTreeContextButton () {
        super(MenuBarData.getLatexTruthTree().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}