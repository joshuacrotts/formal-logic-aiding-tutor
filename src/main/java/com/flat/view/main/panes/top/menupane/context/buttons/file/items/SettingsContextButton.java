package com.flat.view.main.panes.top.menupane.context.buttons.file.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.file.items.SettingsMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.settings.SettingsStage;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsContextButton extends ContextButton {

    public SettingsContextButton () {
        super(Controller.MAPPED_TEXT.getValue(SettingsMenuItem.class, SettingsMenuItem.Keys.SETTINGS));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            new SettingsStage();
        });
    }

}