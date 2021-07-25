package com.flat.view.main.panes.top.menupane.context.buttons.help.items;

import com.flat.controller.Controller;
import com.flat.models.data.menubar.menus.help.items.AboutMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AboutContextButton extends ContextButton {

    public AboutContextButton() {
        super(Controller.MAPPED_TEXT.getValue(AboutMenuItem.class, AboutMenuItem.Keys.ABOUT));
    }

}