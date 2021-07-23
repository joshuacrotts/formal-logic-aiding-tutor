package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.file.items.ResetViewMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ResetViewContextButton extends ContextButton {

    public ResetViewContextButton () {
        super(Controller.MAPPED_TEXT.getValue(ResetViewMenuItem.class, ResetViewMenuItem.Keys.RESET));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            this.resetView();
        });
    }

    private void resetView () {
        Controller.resetView();
        ((Stage)this.getScene().getWindow()).close();
    }

}