package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.biconditional.BiconditionalSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenuItem;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BiconditionalMenuItem2 extends LogicContextMenuItem {

    public BiconditionalMenuItem2 () {
        super(Controller.MAPPED_TEXT.getValue(BiconditionalSymbol.class, LogicSymbol.Keys.ALTERNATE_2));
    }

}