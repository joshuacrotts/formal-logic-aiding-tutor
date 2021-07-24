package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate.DisjunctionMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate.DisjunctionMenuItem2;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate.DisjunctionMenuItem3;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.alternate.DisjunctionMenuItem4;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DisjunctionContextMenu extends LogicContextMenu {

    public DisjunctionContextMenu () {
        super (
                new DisjunctionMenuItem1(),
                new DisjunctionMenuItem2(),
                new DisjunctionMenuItem3(),
                new DisjunctionMenuItem4()
        );
    }

}