package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import javafx.scene.control.ContextMenu;

import java.util.Arrays;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicContextMenu extends ContextMenu {
    private LogicButton owner = null;

    public LogicContextMenu (LogicContextMenuItem... _menuItems) {
        super.getItems().addAll(Arrays.asList(_menuItems));
        super.getStyleClass().add("logicContextMenu");
    }

    // Getters for object's attributes.
    public LogicButton getOwner() {
        return owner;
    }

    // Setters for object's attributes.
    public void setOwner(LogicButton owner) {
        this.owner = owner;
    }

}