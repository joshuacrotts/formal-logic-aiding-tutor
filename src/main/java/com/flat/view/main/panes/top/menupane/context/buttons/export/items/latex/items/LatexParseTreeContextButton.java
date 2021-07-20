package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.export.JsonLatexParseTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexParseTreeContextButton extends ContextButton {

    public LatexParseTreeContextButton () {
        super(Controller.getKEYED_TEXT().getValue(JsonLatexParseTreeMenuItem.class, JsonLatexParseTreeMenuItem.Keys.LATEX_PARSE_TREE).textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}