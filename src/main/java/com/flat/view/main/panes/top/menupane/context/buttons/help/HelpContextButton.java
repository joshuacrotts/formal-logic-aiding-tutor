package com.flat.view.main.panes.top.menupane.context.buttons.help;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.help.items.AboutContextButton;
import com.flat.view.data.menubar.MenuBarData;
import com.flat.view.data.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class HelpContextButton extends ContextButton {

    public HelpContextButton () {
        super(MenuBarData.getHelp().textProperty(), new AboutContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}