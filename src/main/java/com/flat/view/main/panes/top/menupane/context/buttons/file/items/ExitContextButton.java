package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.menubar.MenuBarData;
import com.flat.view.data.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExitContextButton extends ContextButton {

    public ExitContextButton () {
        super(MenuBarData.getExit().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            System.exit(0);
        });
    }

}