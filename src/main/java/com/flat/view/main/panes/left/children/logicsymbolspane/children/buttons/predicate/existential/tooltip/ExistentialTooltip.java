package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialTooltip extends LogicTooltip {

    public ExistentialTooltip() {
        super(Controller.MAPPED_TEXT.getValue(ExistentialSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}