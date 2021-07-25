package com.flat.view.main.panes.top.menupane.context.buttons.file;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.file.FileMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ExitContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ResetViewContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.SettingsContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FileContextButton extends ContextButton {

    public FileContextButton () {
        super(Controller.MAPPED_TEXT.getValue(FileMenu.class, FileMenu.Keys.FILE),
                new ResetViewContextButton(),
                new SettingsContextButton(),
                new ExitContextButton()
        );
    }

}