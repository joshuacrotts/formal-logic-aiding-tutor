package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DoubleTurnstileTooltip extends LogicTooltip {

    public DoubleTurnstileTooltip () {
        super(Controller.MAPPED_TEXT.getValue(DoubleTurnstileSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}