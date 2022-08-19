package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.contextmenu.menuitems.alternate.*;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExclusiveDisjunctionContextMenu extends LogicContextMenu {

    public ExclusiveDisjunctionContextMenu () {
        super(
                new ExclusiveDisjunctionMenuItem1(),
                new ExclusiveDisjunctionMenuItem2(),
                new ExclusiveDisjunctionMenuItem3(),
                new ExclusiveDisjunctionMenuItem4(),
                new ExclusiveDisjunctionMenuItem5(),
                new ExclusiveDisjunctionMenuItem6()
        );
    }

}