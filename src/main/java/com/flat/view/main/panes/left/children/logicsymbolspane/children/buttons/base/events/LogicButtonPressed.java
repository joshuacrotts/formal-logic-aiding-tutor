package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.events;

import com.flat.models.data.logicsymbols.LogicSymbols.SymbolKey;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicButtonPressed extends Event {
    private String text;
    private SymbolKey symbolKey;
    public LogicButtonPressed (String _text, SymbolKey _symbolKey) {
        super(Event.Type.LOGIC_BUTTON_PRESSED);
        this.text = _text;
        this.symbolKey = _symbolKey;
    }

    // Getters for object's attributes.
    public String getText() {
        return text;
    }

    public SymbolKey getSymbolKey() {
        return symbolKey;
    }

    // Setters for object's attributes.
    public void setText(String text) {
        this.text = text;
    }

    public void setSymbolKey(SymbolKey symbolKey) {
        this.symbolKey = symbolKey;
    }

}