package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.NegationContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.tooltip.NegationTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NegationLogicButton extends LogicButton {

    public NegationLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(NegationSymbol.class, LogicSymbol.Keys.TOOL_TIP),
                new NegationTooltip(),
                new NegationContextMenu()
        );
    }

}