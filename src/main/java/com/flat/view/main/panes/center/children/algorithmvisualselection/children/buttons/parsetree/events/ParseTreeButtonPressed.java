package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeButtonPressed extends Event {

    public ParseTreeButtonPressed () {
        super(Event.Type.PARSE_TREE_BUTTON_PRESSED);
    }

}