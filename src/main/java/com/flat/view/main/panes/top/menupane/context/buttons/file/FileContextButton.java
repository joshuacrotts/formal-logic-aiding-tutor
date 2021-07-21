package com.flat.view.main.panes.top.menupane.context.buttons.file;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.menus.JsonFileMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ExitContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ResetViewContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.SettingsContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FileContextButton extends ContextButton {

    public FileContextButton () {
        super(Controller.getMAPPED_TEXT().getValue(JsonFileMenu.class, JsonFileMenu.Keys.FILE),
                new ResetViewContextButton(),
                new SettingsContextButton(),
                new ExitContextButton()
        );
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}