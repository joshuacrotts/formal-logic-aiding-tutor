package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NegationMenuItem3 extends LogicContextMenuItem {

    public NegationMenuItem3 () {
        super(Controller.MAPPED_TEXT.getValue(NegationSymbol.class, LogicSymbol.Keys.ALTERNATE_3));
    }

}