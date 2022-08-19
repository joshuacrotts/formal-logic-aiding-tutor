package com.flat.tools.buses.databus;

import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.EventBus;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DataBus {
    private static DataBus instance = null;
    private ArrayList <DataListener> listeners = new ArrayList ();

    private DataBus () {
    }

    public static DataBus getInstance () {
        if (instance == null)
            instance = new DataBus();
        return instance;
    }

    public void throwUpdate (Update _update) {
        System.out.println("Data Update: " + _update.getType());
        this.listeners.forEach(listener -> {
            try {
                listener.handleUpdate(_update);
            }
            catch (Exception e) {
                Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, null, e);
            }
        });
    }

    public void addListener (DataListener _listener) {
        this.listeners.add(_listener);
    }

    public void removeListener (DataListener _listener) {
        this.listeners.remove(_listener);
    }

    public ArrayList <DataListener> getListeners () {
        return this.listeners;
    }

    public void resetListeners () {
        this.listeners.removeAll(this.getListeners());
    }

}