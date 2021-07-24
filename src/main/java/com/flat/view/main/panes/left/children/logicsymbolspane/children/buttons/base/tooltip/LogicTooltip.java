package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip;

import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicTooltip extends Tooltip{

    public LogicTooltip (Text _text) {
        super.textProperty().bind(_text.textProperty());
        super.fontProperty().bind(_text.fontProperty());
        super.getStyleClass().add("logicToolTip");
    }

}