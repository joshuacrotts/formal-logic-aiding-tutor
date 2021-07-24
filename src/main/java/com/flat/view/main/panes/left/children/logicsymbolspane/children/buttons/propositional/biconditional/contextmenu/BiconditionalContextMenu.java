package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate.BiconditionalMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate.BiconditionalMenuItem2;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate.BiconditionalMenuItem3;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.menuitems.alternate.BiconditionalMenuItem4;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BiconditionalContextMenu extends LogicContextMenu {

    public BiconditionalContextMenu () {
        super(
                new BiconditionalMenuItem1(),
                new BiconditionalMenuItem2(),
                new BiconditionalMenuItem3(),
                new BiconditionalMenuItem4()
        );
    }

}