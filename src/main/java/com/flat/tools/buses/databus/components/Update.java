package com.flat.tools.buses.databus.components;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Update {

    public static enum Type {
        APPLICABLE_ALGORITHMS,
        PRACTICE_MODE_TOGGLE,

        // Events thrown from new practice panes.
        PRACTICE_PANE_UPDATE,

        // Events thrown from practice pane.
        PRACTICE_RESULT,
    }

    private Type type;

    public Update (Type _type) {
        this.type = _type;
    }

    // Getters for object's attributes.
    public Type getType() {
        return type;
    }

    // Setters for object's attributes.
    public void setType(Type type) {
        this.type = type;
    }

}