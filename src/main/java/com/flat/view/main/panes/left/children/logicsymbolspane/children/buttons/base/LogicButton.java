package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base;

import com.flat.controller.Controller;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.events.LogicButtonPressed;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicButton extends Button {

    public LogicButton (Text _general, LogicTooltip _tooltip, LogicContextMenu _logicContextMenu) {
        super.setText(_general.getText());
        super.setTooltip(_tooltip);
        super.setContextMenu(_logicContextMenu);
        _logicContextMenu.setOwner(this);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setMaxWidth(Double.MAX_VALUE);
        super.setPrefSize(30, 30);
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new LogicButtonPressed(super.getText()));
        });
    }

}