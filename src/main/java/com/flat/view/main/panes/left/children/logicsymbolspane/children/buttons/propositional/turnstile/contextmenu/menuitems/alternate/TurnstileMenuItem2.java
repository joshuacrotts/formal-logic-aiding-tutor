package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TurnstileMenuItem2 extends LogicContextMenuItem {

    public TurnstileMenuItem2 () {
        super(Controller.MAPPED_TEXT.getValue(TurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_2));
    }

}