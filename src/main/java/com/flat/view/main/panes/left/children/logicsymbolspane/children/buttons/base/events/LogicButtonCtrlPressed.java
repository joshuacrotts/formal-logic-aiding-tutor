package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.events;

import com.flat.models.data.logicsymbols.LogicSymbols.SymbolKey;
import com.flat.tools.buses.eventbus.components.Event;

import static com.flat.tools.buses.eventbus.components.Event.Type.LOGIC_BUTTON_CTRL_PRESSED;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicButtonCtrlPressed extends Event {
    private SymbolKey key;

    public LogicButtonCtrlPressed (SymbolKey _key) {
        super(LOGIC_BUTTON_CTRL_PRESSED);
        this.key = _key;
    }

    // Getters for object's attributes.
    public SymbolKey getKey() {
        return key;
    }

    // Setters for object's attributes.
    public void setKey(SymbolKey key) {
        this.key = key;
    }

}