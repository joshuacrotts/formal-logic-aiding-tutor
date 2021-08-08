package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTableMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable.events.ExportLatexTruthTable;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable.listener.LatexTruthTableContextButtonListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTableContextButton extends ContextButton {

    public LatexTruthTableContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTableMenuItem.class, LatexTruthTableMenuItem.Keys.LATEX_TRUTH_TABLE));
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new LatexTruthTableContextButtonListener(this));
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
            Controller.EVENT_BUS.throwEvent(new ExportLatexTruthTable());
        });
    }

}