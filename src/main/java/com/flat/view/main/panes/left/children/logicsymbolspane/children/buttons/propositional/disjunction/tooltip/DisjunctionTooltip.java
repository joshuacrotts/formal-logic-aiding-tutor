package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DisjunctionTooltip extends LogicTooltip {

    public DisjunctionTooltip () {
        super(Controller.MAPPED_TEXT.getValue(DisjunctionSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}