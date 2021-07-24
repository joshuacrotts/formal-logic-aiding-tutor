package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicButton extends Button {

    public LogicButton (Text _general, LogicTooltip _tooltip, LogicContextMenu _logicContextMenu) {
        super.textProperty().bind(_general.textProperty());
        super.setTooltip(_tooltip);
        super.setContextMenu(_logicContextMenu);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setMaxWidth(Double.MAX_VALUE);
        super.setPrefSize(30, 30);
    }

}