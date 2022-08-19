package com.flat.view.main.panes.center.children.practice.listener.events;

import com.flat.tools.buses.databus.components.Update;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeResult extends Update {
    private Boolean result;

    public PracticeResult (Boolean _result) {
        super(Type.PRACTICE_RESULT);
        this.result = _result;
    }

    // Getters for object's attributes.
    public Boolean isResult() {
        return result;
    }

    // Setters for object's attributes.
    public void setResult(Boolean result) {
        this.result = result;
    }

}