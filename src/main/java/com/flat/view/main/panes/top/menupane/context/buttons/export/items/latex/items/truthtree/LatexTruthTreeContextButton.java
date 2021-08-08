package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtree;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexTruthTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtree.events.ExportLatexTruthTree;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtree.listener.LatexTruthTreeContextButtonListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTreeContextButton extends ContextButton {

    public LatexTruthTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexTruthTreeMenuItem.class, LatexTruthTreeMenuItem.Keys.LATEX_TRUTH_TREE));
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new LatexTruthTreeContextButtonListener(this));
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
            Controller.EVENT_BUS.throwEvent(new ExportLatexTruthTree());
        });
    }

}