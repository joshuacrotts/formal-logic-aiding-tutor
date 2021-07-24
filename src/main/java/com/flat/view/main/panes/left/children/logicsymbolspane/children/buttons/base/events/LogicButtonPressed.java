package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicButtonPressed extends Event {
    private String text;

    public LogicButtonPressed (String _text) {
        super(Event.Type.LOGIC_BUTTON_PRESSED);
        this.text = _text;
    }

    // Getters for object's attributes.
    public String getText() {
        return text;
    }

    // Setters for object's attributes.
    public void setText(String text) {
        this.text = text;
    }

}