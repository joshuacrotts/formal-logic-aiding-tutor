package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author christopherbrantley
 */
public class TruthTreeButtonPressed extends Event {

    public TruthTreeButtonPressed() {
        super(Type.TRUTH_TREE_BUTTON_PRESSED);
    }

}