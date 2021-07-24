package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.contextmenu.menuitems.alternate.UniversalMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.contextmenu.menuitems.alternate.UniversalMenuItem2;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalContextMenu extends LogicContextMenu {

    public UniversalContextMenu () {
        super(new UniversalMenuItem1(),
                new UniversalMenuItem2()
        );
    }

}