package com.flat.view.main.panes.top.menupane.context.buttons.help.items;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.menubar.MenuBarData;
import com.flat.view.data.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AboutContextButton extends ContextButton {

    public AboutContextButton() {
        super(MenuBarData.getAbout().textProperty());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}