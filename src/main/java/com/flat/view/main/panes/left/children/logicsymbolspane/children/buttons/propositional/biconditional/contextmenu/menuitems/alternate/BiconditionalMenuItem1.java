package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.biconditional.attributes.BiconditionalSymbols;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BiconditionalMenuItem1 extends LogicContextMenuItem {

    public BiconditionalMenuItem1 () {
        super(Controller.MAPPED_TEXT.getValue(BiconditionalSymbols.class, LogicSymbol.Keys.ALTERNATE_1));
    }

}