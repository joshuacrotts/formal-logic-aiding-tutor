package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExclusiveDisjunctionTooltip extends LogicTooltip {

    public ExclusiveDisjunctionTooltip () {
        super(Controller.MAPPED_TEXT.getValue(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}