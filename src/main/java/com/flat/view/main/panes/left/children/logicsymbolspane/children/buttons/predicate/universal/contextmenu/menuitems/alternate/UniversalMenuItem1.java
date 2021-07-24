package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalMenuItem1 extends LogicContextMenuItem {

    public UniversalMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(UniversalSymbol.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}
