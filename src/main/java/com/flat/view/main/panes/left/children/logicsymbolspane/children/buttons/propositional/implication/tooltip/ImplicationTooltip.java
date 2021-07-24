package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ImplicationTooltip extends LogicTooltip {

    public ImplicationTooltip () {
        super(Controller.MAPPED_TEXT.getValue(ImplicationSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}