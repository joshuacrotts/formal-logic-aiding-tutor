package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.conjunction.ConjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ConjunctionMenuItem1 extends LogicContextMenuItem {

    public ConjunctionMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(ConjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}