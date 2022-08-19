package com.flat.view.main.panes.right.children.selection.children.selections.buttons.practice.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSelectionButtonPressed extends Event {

    public PracticeSelectionButtonPressed () {
        super(Type.PRACTICE_SELECTION_BUTTON_PRESSED);
    }

}