package com.flat.view.main.panes.top.menupane.context.buttons.help;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.help.HelpMenu;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.help.items.AboutContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class HelpContextButton extends ContextButton {

    public HelpContextButton () {
        super(Controller.MAPPED_TEXT.getValue(HelpMenu.class, HelpMenu.Keys.HELP), new AboutContextButton());
    }

}