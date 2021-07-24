package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu;

import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicContextMenuItem extends MenuItem {

    public LogicContextMenuItem (Text _text) {
        super.textProperty().bind(_text.textProperty());
        super.getStyleClass().add("logicContextMenuItem");
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.setThisOnAction();
    }

    private void setThisOnAction () {
        super.setOnAction(event -> {
            ((LogicContextMenu)super.getParentPopup()).getOwner().setText(super.getText());
        });
    }

}