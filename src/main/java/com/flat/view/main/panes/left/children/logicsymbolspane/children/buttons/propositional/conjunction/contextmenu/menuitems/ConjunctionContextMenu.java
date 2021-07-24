package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.alternate.ConjunctionMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.alternate.ConjunctionMenuItem2;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.alternate.ConjunctionMenuItem3;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.alternate.ConjunctionMenuItem4;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ConjunctionContextMenu extends LogicContextMenu {

    public ConjunctionContextMenu () {
        super(
                new ConjunctionMenuItem1(),
                new ConjunctionMenuItem2(),
                new ConjunctionMenuItem3(),
                new ConjunctionMenuItem4()
        );
    }

}