package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu;

import java.util.Arrays;
import javafx.scene.control.ContextMenu;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicContextMenu extends ContextMenu {

    public LogicContextMenu (LogicContextMenuItem... _menuItems) {
        super.getItems().addAll(Arrays.asList(_menuItems));
    }

}