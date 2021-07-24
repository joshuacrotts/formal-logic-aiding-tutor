package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExclusiveDisjunctionMenuItem6 extends LogicContextMenuItem {

    public ExclusiveDisjunctionMenuItem6 () {
        super(Controller.MAPPED_TEXT.getValue(ExclusiveDisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_6));
    }

}