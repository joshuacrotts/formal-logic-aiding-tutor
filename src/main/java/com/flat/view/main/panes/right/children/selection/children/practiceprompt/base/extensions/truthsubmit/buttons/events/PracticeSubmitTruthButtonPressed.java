package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.buttons.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeSubmitTruthButtonPressed extends Event {
    private boolean truth;

    public PracticeSubmitTruthButtonPressed (boolean _truth) {
        super(Type.PRACTICE_SUBMIT_TRUTH_BUTTON_PRESSED);
        this.truth = _truth;
    }

    // Getters for object's attributes.
    public boolean isTruth() {
        return truth;
    }

    // Setters for object's attributes.
    public void setTruth(boolean truth) {
        this.truth = truth;
    }

}