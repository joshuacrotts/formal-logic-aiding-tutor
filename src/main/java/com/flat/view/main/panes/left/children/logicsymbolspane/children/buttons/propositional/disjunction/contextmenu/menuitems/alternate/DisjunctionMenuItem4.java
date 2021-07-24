package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.disjunction.attributes.DisjunctionSymbols;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DisjunctionMenuItem4 extends LogicContextMenuItem {

    public DisjunctionMenuItem4 () {
        super(Controller.MAPPED_TEXT.getValue(DisjunctionSymbols.class, LogicSymbol.Keys.EXAMPLE_4));
    }

}