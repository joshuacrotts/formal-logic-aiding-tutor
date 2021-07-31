package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.children.submit.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSubmitButtonPressed extends Event {

    public PracticeSubmitButtonPressed () {
        super(Event.Type.PRACTICE_SUBMIT_BUTTON_PRESSED);
    }

}