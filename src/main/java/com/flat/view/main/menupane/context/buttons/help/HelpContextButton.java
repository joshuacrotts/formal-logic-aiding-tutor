package com.flat.view.main.menupane.context.buttons.help;

import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.main.menupane.context.buttons.help.items.AboutContextButton;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.pane.PaneData;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class HelpContextButton extends ContextButton {

    public HelpContextButton () {
        super(MenuBarData.getHelp().textProperty(), new AboutContextButton());
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}