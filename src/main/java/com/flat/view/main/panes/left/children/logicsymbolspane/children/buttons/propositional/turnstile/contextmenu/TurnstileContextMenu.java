package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.contextmenu;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.contextmenu.menuitems.alternate.TurnstileMenuItem1;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.contextmenu.menuitems.alternate.TurnstileMenuItem2;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TurnstileContextMenu extends LogicContextMenu {

    public TurnstileContextMenu () {
        super(
                new TurnstileMenuItem1(),
                new TurnstileMenuItem2()
        );
    }

}