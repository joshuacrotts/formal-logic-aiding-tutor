package com.flat.view.main.panes.top.menupane.context.buttons.export;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.menus.export.JsonExportMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.LatexContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.PdfContextButton;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportMenuButton extends ContextButton {

    public ExportMenuButton () {
        super(Controller.getKEYED_TEXT().getValue(JsonExportMenu.class, JsonExportMenu.Key.EXPORT).textProperty(),
                new LatexContextButton(),
                new PdfContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
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