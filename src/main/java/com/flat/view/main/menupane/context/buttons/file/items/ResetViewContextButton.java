package com.flat.view.main.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ResetViewContextButton extends ContextButton {

    public ResetViewContextButton () {
        super(MenuBarData.getResetView().textProperty());
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