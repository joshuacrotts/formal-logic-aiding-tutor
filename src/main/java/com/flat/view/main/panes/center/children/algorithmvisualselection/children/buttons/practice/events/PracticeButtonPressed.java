package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.practice.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeButtonPressed extends Event {

    public PracticeButtonPressed () {
        super(Event.Type.PRACTICE_BUTTON_PRESSED);
    }

}