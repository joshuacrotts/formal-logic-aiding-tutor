package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DoubleTurnstileMenuItem1 extends LogicContextMenuItem {

    public DoubleTurnstileMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(DoubleTurnstileSymbol.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}