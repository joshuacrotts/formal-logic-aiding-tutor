package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NegationTooltip extends LogicTooltip {

    public NegationTooltip () {
        super(Controller.MAPPED_TEXT.getValue(NegationSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}