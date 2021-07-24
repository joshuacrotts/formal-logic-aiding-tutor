package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons;

import com.flat.models.data.logicsymbols.base.LogicSymbol;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbolsButton extends Button {

    public LogicSymbolsButton (String _key, LogicSymbol _logicSymbol) {
        super.textProperty().bind(_logicSymbol.getSymbols().getGeneral().textProperty());
        super.setTooltip(new Tooltip());
        //super.getTooltip().textProperty().bind(Controller.MAPPED_TEXT.getValue(_key, LogicSymbol.Keys.TOOL_TIP).textProperty());
        super.setMaxWidth(Double.MAX_VALUE);
        super.setPrefSize(30, 30);
    }

}