package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.menuitems.alternate.ImplicationMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.menuitems.alternate.ImplicationMenuItem2;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.menuitems.alternate.ImplicationMenuItem3;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.menuitems.alternate.ImplicationMenuItem4;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ImplicationContextMenu extends LogicContextMenu {

    public ImplicationContextMenu () {
        super(
                new ImplicationMenuItem1(),
                new ImplicationMenuItem2(),
                new ImplicationMenuItem3(),
                new ImplicationMenuItem4()
        );
    }

}