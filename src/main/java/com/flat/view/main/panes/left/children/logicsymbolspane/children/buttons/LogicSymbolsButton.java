package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons;

import com.flat.controller.Controller;
import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbolsButton extends Button {

    public LogicSymbolsButton (String _key, LogicSymbol _logicSymbol) {
        super(_logicSymbol.getSymbols().getGeneral());
        super.setTooltip(new Tooltip());
        super.getTooltip().textProperty().bind(Controller.getMAPPED_TEXT().getValue(_key, KeyedLogicSymbol.Keys.TOOL_TIP).textProperty());
        super.setMaxWidth(Double.MAX_VALUE);
        super.setPrefSize(30, 30);
    }

}