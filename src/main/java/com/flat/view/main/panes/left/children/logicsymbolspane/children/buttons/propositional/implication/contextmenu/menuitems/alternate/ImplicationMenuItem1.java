package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ImplicationMenuItem1 extends LogicContextMenuItem {

    public ImplicationMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(ImplicationSymbol.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}