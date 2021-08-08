package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.type.items.LatexParseTreeMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree.events.ExportLatexParseTree;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree.listener.LatexParseTreeContextButtonListener;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexParseTreeContextButton extends ContextButton {

    public LatexParseTreeContextButton () {
        super(Controller.MAPPED_TEXT.getValue(LatexParseTreeMenuItem.class, LatexParseTreeMenuItem.Keys.LATEX_PARSE_TREE));
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new LatexParseTreeContextButtonListener(this));
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
            Controller.EVENT_BUS.throwEvent(new ExportLatexParseTree());
        });
    }

}