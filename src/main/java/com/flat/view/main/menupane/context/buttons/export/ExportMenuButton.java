package com.flat.view.main.menupane.context.buttons.export;

import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.main.menupane.context.buttons.export.items.latex.LatexContextButton;
import com.flat.view.main.menupane.context.buttons.export.items.pdf.PdfContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportMenuButton extends ContextButton {

    public ExportMenuButton () {
        super(MenuBarData.getExport().textProperty(),
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