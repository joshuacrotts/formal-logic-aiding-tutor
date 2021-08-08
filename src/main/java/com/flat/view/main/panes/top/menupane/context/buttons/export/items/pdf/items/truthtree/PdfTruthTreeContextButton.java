package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree.events.ExportPdfTruthTree;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree.listener.PdfTruthTreeContextButtonListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTreeContextButton extends ContextButton {

    public PdfTruthTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTreeMenuItem.class, LatexTruthTreeMenuItem.Keys.LATEX_TRUTH_TREE));
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new PdfTruthTreeContextButtonListener(this));
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
            Controller.EVENT_BUS.throwEvent(new ExportPdfTruthTree());
        });
    }

}