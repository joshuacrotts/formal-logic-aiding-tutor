package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTableMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTableContextButton extends ContextButton {

    public PdfTruthTableContextButton () {
        super(Controller.getKEYED_TEXT().getValue(JsonLatexTruthTableMenuItem.class, JsonLatexTruthTableMenuItem.Keys.LATEX_TRUTH_TABLE).textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}