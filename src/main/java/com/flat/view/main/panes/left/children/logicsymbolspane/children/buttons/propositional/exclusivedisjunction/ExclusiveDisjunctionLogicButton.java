package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.contextmenu.ExclusiveDisjunctionContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.tooltip.ExclusiveDisjunctionTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExclusiveDisjunctionLogicButton extends LogicButton {

    public ExclusiveDisjunctionLogicButton () {
        super(Controller.MAPPED_TEXT.getValue(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.GENERAL),
                new ExclusiveDisjunctionTooltip(),
                new ExclusiveDisjunctionContextMenu()
        );
    }

}