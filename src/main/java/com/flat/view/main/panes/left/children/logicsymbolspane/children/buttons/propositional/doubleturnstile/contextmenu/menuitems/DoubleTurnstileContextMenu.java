package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.contextmenu.menuitems;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.contextmenu.menuitems.alternate.DoubleTurnstileMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.contextmenu.menuitems.alternate.DoubleTurnstileMenuItem2;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DoubleTurnstileContextMenu extends LogicContextMenu {

    public DoubleTurnstileContextMenu () {
        super(
                new DoubleTurnstileMenuItem1(),
                new DoubleTurnstileMenuItem2()
        );
    }

}