package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.menuitems.alternate.NegationMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.menuitems.alternate.NegationMenuItem2;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.menuitems.alternate.NegationMenuItem3;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.contextmenu.menuitems.alternate.NegationMenuItem4;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NegationContextMenu extends LogicContextMenu {

    public NegationContextMenu () {
        super(
                new NegationMenuItem1(),
                new NegationMenuItem2(),
                new NegationMenuItem3(),
                new NegationMenuItem4()
        );
    }

}