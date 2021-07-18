package com.flat.tools.eventbus.events.parsererrors;

import com.flat.input.FLATErrorListener.Message;
import com.flat.tools.eventbus.base.Event;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxError extends Event {
    private Iterator<Message> errorIterator;

    public SyntaxError(Iterator<Message> _errorIterator) {
        super(Event.Type.SYNTAX_ERROR);
        this.errorIterator = _errorIterator;
    }

    // Getters for object's attributes.
    public Iterator<Message> getErrorIterator() {
        return errorIterator;
    }

    // Setters for object's attributes.
    public void setErrorIterator(Iterator<Message> errorIterator) {
        this.errorIterator = errorIterator;
    }

}