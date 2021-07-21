package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.export.JsonLatexParseTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfParseTreeContextButton extends ContextButton {

    public PdfParseTreeContextButton () {
        super(Controller.getMAPPED_TEXT().getValue(JsonLatexParseTreeMenuItem.class, JsonLatexParseTreeMenuItem.Keys.LATEX_PARSE_TREE));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}