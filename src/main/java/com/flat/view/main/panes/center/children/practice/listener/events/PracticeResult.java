package com.flat.view.main.panes.center.children.practice.listener.events;

import com.flat.tools.buses.databus.components.Update;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeResult extends Update {
    private boolean result;

    public PracticeResult (boolean _result) {
        super(Update.Type.PRACTICE_RESULT);
        this.result = _result;
    }

    // Getters for object's attributes.
    public boolean isResult() {
        return result;
    }

    // Setters for object's attributes.
    public void setResult(boolean result) {
        this.result = result;
    }

}