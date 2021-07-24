package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalTooltip extends LogicTooltip {

    public UniversalTooltip() {
        super(Controller.MAPPED_TEXT.getValue(UniversalSymbol.class, UniversalSymbol.Keys.TOOL_TIP));
    }

}