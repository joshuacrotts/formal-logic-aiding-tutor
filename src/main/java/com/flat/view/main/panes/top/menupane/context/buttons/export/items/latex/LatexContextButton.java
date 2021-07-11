package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexParseTreeContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexTruthTableContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.LatexTruthTreeContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexContextButton extends ContextButton {

    public LatexContextButton () {
        super(MenuBarData.getExportAsLatex().textProperty(),
                new LatexParseTreeContextButton(),
                new LatexTruthTreeContextButton(),
                new LatexTruthTableContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.setOffsetY(-ContextButton.MENU_HEIGHT / 2);
        super.setOffsetX(ContextButton.MENU_WIDTH);
    }

}