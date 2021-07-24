package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.tooltip;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.biconditional.BiconditionalSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ConjunctionTooltip extends LogicTooltip {

    public ConjunctionTooltip () {
        super(Controller.MAPPED_TEXT.getValue(BiconditionalSymbol.class, LogicSymbol.Keys.TOOL_TIP));
    }

}