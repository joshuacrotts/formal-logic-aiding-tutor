package com.flat.view.main.panes.top.menupane.context.buttons.export;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.export.ExportMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.LatexContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.PdfContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportMenuButton extends ContextButton {

    public ExportMenuButton () {
        super(Controller.MAPPED_TEXT.getValue(ExportMenu.class, ExportMenu.Keys.EXPORT),
                new LatexContextButton(),
                new PdfContextButton());
        this.setOnMouseEntered();
    }

    private void setOnMouseEntered () {
        super.getContextWindow().getChildren().forEach(button -> {
            this.setOnMouseEnteredContextItem((ContextButton)button);
        });
    }

    private void setOnMouseEnteredContextItem (ContextButton _button) {
        _button.setOnMouseEntered(event -> {
            _button.setToggle(true);
            super.getContextWindow().getChildren().forEach(button2 -> {
               if (!_button.equals(button2))
                   ((ContextButton)button2).setToggle(false);
            });
        });
    }

}