package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTableMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable.events.ExportPdfTruthTable;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable.listener.PdfTruthTableContextButtonListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTableContextButton extends ContextButton {

    public PdfTruthTableContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTableMenuItem.class, LatexTruthTableMenuItem.Keys.LATEX_TRUTH_TABLE));
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new PdfTruthTableContextButtonListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setDisable(true);
        this.setOnThisAction();
    }

    private void setOnThisAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new ExportPdfTruthTable());
        });
    }

}