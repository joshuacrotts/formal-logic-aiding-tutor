package com.flat.tools.eventbus.events.parsererrors;

import com.flat.input.FLATErrorListener.Message;
import com.flat.tools.eventbus.base.Event;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxWarning extends Event {
    private Iterator<Message> warningIterator;

    public SyntaxWarning(Iterator<Message> _warningIterator) {
        super(Event.Type.SYNTAX_WARNING);
        this.warningIterator = _warningIterator;
    }

    // Getters for object's properties.
    public Iterator<Message> getWarningIterator() {
        return warningIterator;
    }

    // Setters for object's properties.
    public void setWarningIterator(Iterator<Message> warningIterator) {
        this.warningIterator = warningIterator;
    }

}