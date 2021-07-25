package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DisjunctionMenuItem3 extends LogicContextMenuItem {

    public DisjunctionMenuItem3 () {
        super(Controller.MAPPED_TEXT.getValue(DisjunctionSymbol.class, LogicSymbol.Keys.ALTERNATE_3));
    }

}