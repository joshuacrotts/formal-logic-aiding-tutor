package com.flat.view.main.panes.right.children.top.practicetoggle.pane.events;

import com.flat.tools.buses.databus.components.Update;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeToggle extends Update {
    private boolean practice;

    public PracticeModeToggle (boolean _value) {
        super(Update.Type.PRACTICE_MODE_TOGGLE);
        this.practice = _value;
    }

    // Getters for object's attributes.
    public boolean isPractice() {
        return practice;
    }

    // Setters for object's attributes.
    public void setPractice(boolean practice) {
        this.practice = practice;
    }

}