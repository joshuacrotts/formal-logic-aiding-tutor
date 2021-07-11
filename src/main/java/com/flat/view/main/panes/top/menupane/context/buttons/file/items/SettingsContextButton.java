package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.settings.SettingsStage;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsContextButton extends ContextButton {

    public SettingsContextButton () {
        super(MenuBarData.getSettings().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.applyFont(new SettingsStage());
        });
    }

}