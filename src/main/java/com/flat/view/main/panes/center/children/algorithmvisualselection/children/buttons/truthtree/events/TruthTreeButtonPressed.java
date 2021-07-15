package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree.events;

import com.flat.tools.eventbus.base.Event;

/**
 *
 * @author christopherbrantley
 */
public class TruthTreeButtonPressed extends Event {

    public TruthTreeButtonPressed() {
        super(Event.Type.TRUTH_TREE_BUTTON_PRESSED);
    }

}