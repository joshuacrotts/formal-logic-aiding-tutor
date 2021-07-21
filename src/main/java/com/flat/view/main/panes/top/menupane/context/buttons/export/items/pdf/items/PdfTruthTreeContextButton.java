package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTreeContextButton extends ContextButton {

    public PdfTruthTreeContextButton () {
        super(Controller.getKEYED_TEXT().getValue(JsonLatexTruthTreeMenuItem.class, JsonLatexTruthTreeMenuItem.Keys.LATEX_TRUTH_TREE));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}