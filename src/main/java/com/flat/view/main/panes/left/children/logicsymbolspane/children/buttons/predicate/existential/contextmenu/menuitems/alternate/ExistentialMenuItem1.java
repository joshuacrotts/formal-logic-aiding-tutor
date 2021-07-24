package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialMenuItem1 extends LogicContextMenuItem {

    public ExistentialMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(ExistentialSymbol.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}