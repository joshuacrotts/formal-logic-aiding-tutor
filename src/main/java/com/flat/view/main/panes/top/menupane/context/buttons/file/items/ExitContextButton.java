package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.file.items.ExitMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExitContextButton extends ContextButton {

    public ExitContextButton () {
        super(Controller.MAPPED_TEXT.getValue(ExitMenuItem.class, ExitMenuItem.Keys.EXIT));
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            System.exit(0);
        });
    }

}