package com.flat.view.main.panes.top.menupane.context.buttons.file;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ExitContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.ResetViewContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.items.SettingsContextButton;
import com.flat.view.data.menubar.MenuBarData;
import com.flat.view.data.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FileContextButton extends ContextButton {

    public FileContextButton () {
        super(MenuBarData.getFile().textProperty(),
                new ResetViewContextButton(),
                new SettingsContextButton(),
                new ExitContextButton()
        );
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}