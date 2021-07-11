package com.flat.tools.eventbus;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class EventBus {
    private static EventBus instance = null;
    private ArrayList <Listener> listeners = new ArrayList ();

    private EventBus () {
    }

    public static EventBus getInstance () {
        if (instance == null)
            instance = new EventBus();
        return instance;
    }

    public void throwEvent (Event _event) {
        this.listeners.forEach(listener -> {
            try {
                listener.catchEvent(_event);
            }
            catch (Exception e) {
                Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, null, e);
            }
        });
    }

    public void addListener (Listener _listener) {
        this.listeners.add(_listener);
    }

    public void removeListener (Listener _listener) {
        this.listeners.remove(_listener);
    }

    public ArrayList <Listener> getListeners () {
        return this.listeners;
    }

    public void resetListeners () {
        this.listeners.removeAll(this.getListeners());
    }

}