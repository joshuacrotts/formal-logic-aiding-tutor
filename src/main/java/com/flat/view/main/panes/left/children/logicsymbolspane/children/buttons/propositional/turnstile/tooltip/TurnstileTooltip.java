package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TurnstileTooltip extends LogicTooltip {

    public TurnstileTooltip () {
        super(Controller.MAPPED_TEXT.getValue(TurnstileSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}