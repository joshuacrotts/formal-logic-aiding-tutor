package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author christopherbrantley
 */
public class TruthTableButtonPressed extends Event {

    public TruthTableButtonPressed () {
        super(Event.Type.TRUTH_TABLE_BUTTON_PRESSED);
    }

}