package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.LogicSymbols;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.contextmenu.menuitems.DoubleTurnstileContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.tooltip.DoubleTurnstileTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DoubleTurnstileLogicButton extends LogicButton {

    public DoubleTurnstileLogicButton() {
        super(
                LogicSymbols.SymbolKey.DOUBLE_TURNSTILE,
                Controller.MAPPED_TEXT.getValue(DoubleTurnstileSymbol.class, LogicSymbol.Keys.GENERAL),
                new DoubleTurnstileTooltip(),
                new DoubleTurnstileContextMenu()
        );
    }

}