package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.contextmenu.menuitems.alternate.ExistentialMenuItem1;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialContextMenu extends LogicContextMenu {

    public ExistentialContextMenu () {
        super(new ExistentialMenuItem1()
        );
    }

}