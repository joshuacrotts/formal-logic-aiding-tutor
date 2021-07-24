package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.contextmenu.TurnstileContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.tooltip.TurnstileTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TurnstileLogicButton extends LogicButton {

    public TurnstileLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(TurnstileSymbol.class, LogicSymbol.Keys.GENERAL),
                new TurnstileTooltip(),
                new TurnstileContextMenu()
        );
    }

}