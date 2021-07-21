package com.flat.view.main.panes.top.menupane.context.buttons.help.items;

import com.flat.controller.Controller;
import com.flat.models.json.menubar.items.help.JsonAboutMenuItem;
import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.data.fx.pane.PaneData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AboutContextButton extends ContextButton {

    public AboutContextButton() {
        super(Controller.getMAPPED_TEXT().getValue(JsonAboutMenuItem.class, JsonAboutMenuItem.Keys.ABOUT));
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

}